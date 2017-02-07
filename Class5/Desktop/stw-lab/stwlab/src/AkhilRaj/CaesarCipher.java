package AkhilRaj;

public class CaesarCipher implements Cipher{

	private int noOfPositions;
	
	public CaesarCipher(int numberOfPositions)
	{
		
		this.noOfPositions = noOfPositions;
		
	}
	
	public String encrypt(String plaintext)
	{	
		char arr[] = plaintext.toCharArray();
		char z = 'z';
		for(int i = 0; i < plaintext.length(); i++)
		{
			if(noOfPositions > ((int)z - (int)arr[i]))
				arr[i] = (char)((int)'a' + ((int)z - (int)arr[i]));
			else
			arr[i] = (char)((int)arr[i] + noOfPositions);
			System.out.println(arr[i]);
		}
		
		return arr.toString();
	}
	
	
	public String decrypt(String plaintext)
	{
		char arr[] = plaintext.toCharArray();
		char z = 'z';
		for(int i = 0; i < plaintext.length(); i++)
		{
			if(noOfPositions > (int)arr[i])
				arr[i] = (char)((int)'z' - ((int)arr[i] - noOfPositions));
			else
			arr[i] = (char)((int)arr[i] - noOfPositions);
		}
		
		return arr.toString();
	}
	
	public static void main(String args[])
	{
		CaesarCipher abc = new CaesarCipher(3);
		System.out.println(abc.encrypt("asd"));
		
	}
	

}
interface Cipher
{
	public String encrypt(String plaintext);
	public String decrypt(String ciphertext);
}