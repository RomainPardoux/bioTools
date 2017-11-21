package com.sequence;

import java.util.ArrayList;

public interface Sequence {

	void addMonomer(String seq);
	int countMonomer(ArrayList<AminoAcid> aminoAcidList);
	void countAtom(ArrayList<AminoAcid> aminoAcidList);
	Double computeMW(ArrayList<AminoAcid> aminoAcidList);
	
}
