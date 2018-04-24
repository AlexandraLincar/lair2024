package evaluator.repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;


import evaluator.model.Intrebare;
import evaluator.exception.DuplicateIntrebareException;

public class IntrebariRepository {
	
	private List<Intrebare> intrebari;
	
	public IntrebariRepository() {
		setIntrebari(new LinkedList<Intrebare>());
	}
	
	public boolean addIntrebare(Intrebare i) throws DuplicateIntrebareException{
		if(exists(i))
			throw new DuplicateIntrebareException("Intrebarea deja exista!");
		return intrebari.add(i);
	}
	
	public boolean exists(Intrebare i){
		for(Intrebare intrebare : intrebari)
			if(intrebare.equals(i))
				return true;
		return false;
	}
	
	public Intrebare pickRandomIntrebare(){
		Random random = new Random();
		return intrebari.get(random.nextInt(intrebari.size()));
	}
	
	public int getNumberOfDistinctDomains(){
		return getDistinctDomains().size();
		
	}
	
	public Set<String> getDistinctDomains(){
		Set<String> domains = new TreeSet<String>();
		for(Intrebare intrebre : intrebari)
			domains.add(intrebre.getDomeniu());
		return domains;
	}
	
	public List<Intrebare> getIntrebariByDomain(String domain){
		List<Intrebare> intrebariByDomain = new LinkedList<Intrebare>();
		for(Intrebare intrebare : intrebari){
			if(intrebare.getDomeniu().equals(domain)){
				intrebariByDomain.add(intrebare);
			}
		}
		
		return intrebariByDomain;
	}
	
	public int getNumberOfIntrebariByDomain(String domain){
		return getIntrebariByDomain(domain).size();
	}
	
	public List<Intrebare> loadIntrebariFromFile(String f){
		
		List<Intrebare> intrebari = new LinkedList<Intrebare>();
		BufferedReader br = null; 
		String line = null;
		List<String> intrebareAux;
		Intrebare intrebare;
		
		try{
			br = new BufferedReader(new FileReader(f));
			line = br.readLine();
			while(line != null){
				intrebareAux = new LinkedList<String>();
				while(!line.equals("##")){
					intrebareAux.add(line);
					line = br.readLine();
				}
				intrebare = new Intrebare();
				intrebare.setId(intrebareAux.get(0));
				intrebare.setEnunt(intrebareAux.get(1));
				intrebare.setVarianta1(intrebareAux.get(2));
				intrebare.setVarianta2(intrebareAux.get(3));
				intrebare.setVarianta3(intrebareAux.get(4));
				intrebare.setVariantaCorecta(intrebareAux.get(5));
				intrebare.setDomeniu(intrebareAux.get(6));
				intrebari.add(intrebare);
				line = br.readLine();
			}
		
		}
		catch (IOException e) {
			// TODO: handle exception
		}
		finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO: handle exception
			}
		}
		
		return intrebari;
	}

	public void saveIntrebareIntoFile(String fileName, Intrebare newIntrebare) {
		try
		{
			FileWriter fw = new FileWriter(fileName,true); //the true will append the new data
			fw.write("\n");//appends the string to the file
			fw.write( newIntrebare.getId() + "\n");
			fw.write( newIntrebare.getEnunt() + "\n");
			fw.write( newIntrebare.getVarianta1() + "\n");
			fw.write( newIntrebare.getVarianta2() + "\n");
			fw.write( newIntrebare.getVarianta3() + "\n");
			fw.write( newIntrebare.getVariantaCorecta() + "\n");
			fw.write( newIntrebare.getDomeniu() + "\n");
			fw.write( "##");

			fw.close();
		}
		catch(IOException ioe)
		{
			System.err.println("IOException: " + ioe.getMessage());
		}
	}

	public List<Intrebare> getIntrebari() {
		return intrebari;
	}

	public void setIntrebari(List<Intrebare> intrebari) {
		this.intrebari = intrebari;
	}
	
}
