package rotors;

import interfaces.RotationManager;

public class RotorController implements RotationManager{
	
	private Rotor[] activeRotors = new Rotor[5];
	private Rotor decoder = new Rotor();
	
	/*
	 * Constructor
	 * builds a pre-defined Rotor[5]
	 */
	public RotorController() {
		buildRotorArray();
	}
	
	/*
	 * Constructor
	 * @param activeRotors - a pre-filled Rotor[]
	 * this is the constructor we will use in the main Enigma program using
	 * the Rotor[] stored in the Config class within the utilies package
	 */
	public RotorController(Rotor[] activeRotors) {
		this.activeRotors = activeRotors;
	}
	
	/*
	 * Select the rotors to be used and initialize them with the given index
	 */
	@Override
	public void setActiveRotors(Rotor rotor1, int index1, Rotor rotor2, int index2, Rotor rotor3, 
								int index3, Rotor rotor4, int index4, Rotor rotor5, int index5) {
		// TODO Set this up if we ever allow the user to manipulate the rotor configuration	
	}

	/*
	 * Correctly encode a String by using each of the available Rotors
	 */
	@Override
	public String encode(String plaintext) {
		String output = "";
		for (char c: plaintext.toCharArray()) {
			char in = c;
			/*System.out.println("Encoding '" + in + "'...");
			System.out.println(in + " = " + activeRotors[0].encode(in));
			in = activeRotors[0].encode(in);
			System.out.println(in + " = " + activeRotors[1].encode(in));
			in = activeRotors[1].encode(in);
			System.out.println(in + " = " + activeRotors[2].encode(in));
			in = activeRotors[2].encode(in);
			System.out.println(in + " = " + activeRotors[3].encode(in));
			in = activeRotors[3].encode(in);
			System.out.println(in + " = " + activeRotors[4].encode(in));*/
			char out = activeRotors[4].encode(activeRotors[3].encode(activeRotors[2].encode(activeRotors[1].encode(activeRotors[0].encode(c)))));
			// System.out.println("Encoded as '" + out + "'.");
			output += out;
		}
		System.out.println("Encoding...");
		return output;
	}
	
	/*
	 * Correctly decode a String by using each of the available Rotors
	 */
	@Override
	public String decode(String cyphertext) {
		String output = "";
		for (char c: cyphertext.toCharArray()) {
			// char in = c;
			// System.out.println("Decoding '" + in + "'...");
			// System.out.println(in + " = " + decoder.encode(in));
			char out = decoder.encode(c);
			// System.out.println("Encoded as '" + out + "'.");
			output += out;
		}
		System.out.println("Decoding...");
		return output;
	}

	/*
	 * Reset the rotors to the initial configuration given by the user
	 */
	@Override
	public void reset() {
		// TODO Set this up if we ever allow the user to manipulate the rotor configuration
		
	}
	
	/*
	 * Create a default Rotor[5] in case the default constructor is ever called
	 */
	private void buildRotorArray() {
		Rotor r1 = new Rotor();
		r1.setIndex(3);
		activeRotors[0] = r1;
		Rotor r2 = new Rotor();
		r2.setIndex(17);
		activeRotors[1] = r2;
		Rotor r3 = new Rotor();
		r3.setIndex(31);
		activeRotors[2] = r3;
		Rotor r4 = new Rotor();
		r4.setIndex(37);
		activeRotors[3] = r4;
		Rotor r5 = new Rotor();
		r5.setIndex(43);
		activeRotors[4] = r5;
		int decodeIndex = 	r1.getValidCharacters().length() - ((r1.getIndex() + r2.getIndex() + r3.getIndex()
							+ r4.getIndex() + r5.getIndex()) % r1.getValidCharacters().length());
		decoder.setIndex(decodeIndex);
		
	}

}
