package com.sequence;

import java.util.ArrayList;

public interface Sequence {

	public void addMonomer(String seq);
	public int countMonomer(ArrayList<AminoAcid> aminoAcidList);
	public void countAtom(ArrayList<AminoAcid> aminoAcidList);
	public Double computeMW(ArrayList<AminoAcid> aminoAcidList);
	
}
