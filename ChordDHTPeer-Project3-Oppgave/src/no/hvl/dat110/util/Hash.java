package no.hvl.dat110.util;

/**
 * project 3
 * @author tdoy
 *
 */

import java.math.BigInteger;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	private static BigInteger hashint; 
	
	/**
	 * Using the MD5-hashing algorithm to hash a String
	 * @param entity (String)
	 * @return hashint (BigInteger)
	 */
	public static BigInteger hashOf(String entity) {		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		try {
			
			// we use MD5 with 128 bits digest (16 bytes)
			MessageDigest md = MessageDigest.getInstance("MD5");
			// compute the hash of the input 'entity'
			byte[] entityDigest = md.digest(entity.getBytes());
			// convert the hash into hex format
			
			String hashText = toHex(entityDigest);
			
			// convert the hex into BigInteger
			hashint = new BigInteger(hashText, 16);
			
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
		// return the BigInteger
		return hashint;
	}
	
	/**
	 * 
	 * @return Address size of MD5 hashing function
	 */
	public static BigInteger addressSize() {
		
		BigInteger md5AddressSize = null;
		byte[] digest = null;
		// Task: compute the address size of MD5
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			digest = md.digest();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// get the digest length
		int length = digest.length;
		// compute the number of bits = digest length * 8
		int numberOfBits = length * 8;
		BigInteger numberOfBitsBig = new BigInteger("" + numberOfBits);
		BigInteger two = new BigInteger("2");
		// compute the address size = 2 ^ number of bits
		md5AddressSize = two.pow(numberOfBits);
		// return the address size
		
		return md5AddressSize;
	}
	
	/**
	 * 
	 * @return Bit-size of the md5 Hashfunction
	 */
	public static int bitSize() {
		
		int digestlen = 0;
		
		byte[] digest = null;
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		digest = md.digest();
		digestlen = digest.length;
		// find the digest length
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
