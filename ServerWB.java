import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class ServerWB {
	private boolean waiting;
	private final static int PORT = 2000;
	private int curPort;
	private ServerSocket servSock;
	private HashSet<String> dictionary;
	
	public ServerWB(int port) throws IOException
	{
		servSock = new ServerSocket(port);
		waiting = false;
		curPort = 2001;
		initializeDictionary("dictionary.txt");
	}
	
	public void serve() throws IOException
	{
		System.out.println("Listening..");
		for(;;)
		{
			try
			{
				Socket sock1 = servSock.accept();
				System.out.println("Served one client, waiting on another.");
				Socket sock2 = servSock.accept();
				System.out.println("Clients Served");
				(new ClientThread(sock1, sock2)).start();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) throws IOException
	{
		ServerWB s = new ServerWB(PORT);
		s.serve();
	}
		
	private void playServer(Socket p1, Socket p2) throws IOException
	{
		System.out.println("Waiting for game.");
		BufferedReader r1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));;
		PrintWriter o1 = new PrintWriter(p1.getOutputStream(), true);
		BufferedReader r2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));;
		PrintWriter o2 = new PrintWriter(p2.getOutputStream(), true);
		if(curPort > 49150)
			curPort = 2001;
		ServerSocket gameServ = new ServerSocket(curPort++);

		try {
			o1.println((curPort-1)+"");
			o2.println((curPort-1)+"");
			
			String m1 = "";
			String m2 = "";
			String word = "";
			while(!m1.equals("defeat") && !m2.equals("defeat"))
			{
				o1.println("Player Turn");
				r1.close();
				o1.close();
				p1.close();
				p1 = gameServ.accept();
				o1 = new PrintWriter(p1.getOutputStream(), true);
				r1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
				m1 = r1.readLine();
				word += m1;
				System.out.println(word);
				o1.println("WordUpdate: " + word);
				o2.println("WordUpdate: " + word);
				if(checkWord(word))
				{
					o1.println("WordLoss");
					o2.println("WordWin");
					throw new NullPointerException();
				}
				o2.println("Player Turn");
				r2.close();
				o2.close();
				p2.close();
				p2 = gameServ.accept();
				r2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
				o2 = new PrintWriter(p2.getOutputStream(), true);
				m2 = r2.readLine();
				word += m2;
				System.out.println(word);
				o1.println("WordUpdate: " + word);
				o2.println("WordUpdate: " + word);
				if(checkWord(word))
				{
					o1.println("WordWin");
					o2.println("WordLoss");
					throw new NullPointerException();
				}
			}
			System.out.println("Game Over");
		} catch(NullPointerException e) {
			if(isClosed(p1))
			{
				if(!isClosed(p2))
					o2.println("AbandonWin");
			}
			else if(isClosed(p2))
				o1.println("AbandonWin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			o1.close();
			o2.close();
			r1.close();
			r2.close();
			p1.close();
			p2.close();
			gameServ.close();
		}
	}
	
	private class ClientThread extends Thread{
		private final Socket p1;
		private final Socket p2;
		
		public ClientThread(Socket p1, Socket p2) {
			this.p1 = p1;
			this.p2 = p2;
		}

		public void run() {
			try {
				playServer(p1, p2);
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					p1.close();
					p2.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	private void initializeDictionary(String fileName) throws IOException
	{
		StringTokenizer st = new StringTokenizer(fileName, ".");
		String binName = st.nextToken()+".bin";
		File f = new File(binName);
		if(f.exists())
		{
			dictionary = (HashSet<String>) deserialize(binName);
			return;
		}
		BufferedReader r = new BufferedReader(new FileReader(fileName));
		dictionary = new HashSet<String>(95000);
		String word;
		while((word = r.readLine()) != null)
			dictionary.add(word);
		serialize(dictionary, binName);
	}
	
	private static Object deserialize(String fileName)
	{
		Object obj = null;
		
		FileInputStream fis = null;
		ObjectInputStream in = null;

		try
		{
			fis = new FileInputStream(fileName);
			in = new ObjectInputStream(fis);
			obj = in.readObject();
			in.close();
			fis.close();
		}
		catch(IOException ex)
		{
			ex.printStackTrace();
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		return obj;
	}
	
	private static void serialize(Object o, String fileName) {

		try {
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
			out.writeObject(o);
			out.flush();
			out.close();
		} catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}
	
	private boolean checkWord(String word)
	{
		if(word.length() <= 3)
			return false;
		if(dictionary.contains(word))
		{
			System.out.println("True!");
			return true;
		}
		return false;
	}
	
	private static boolean isClosed(Socket s)
	{
		try {
			PrintWriter o = new PrintWriter(s.getOutputStream(), true);
			o.println("test");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return true;
		}
		return false;
	}
}
