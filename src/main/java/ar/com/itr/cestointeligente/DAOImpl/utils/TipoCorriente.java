package ar.com.itr.cestointeligente.DAOImpl.utils;

public class TipoCorriente {
	public static final int RECICLABLES_ID = 1;
	public static final int NO_RECICLABLES_ID = 2;
    public static final TipoCorriente RECICLABLES = new TipoCorriente(TipoCorriente.RECICLABLES_ID, "Reciclables");
    public static final TipoCorriente NORECICLABLES = new TipoCorriente(TipoCorriente.NO_RECICLABLES_ID, "NoReciclables");
	
	private int id;
	private String name;
	
	//Default Constructor
	public TipoCorriente() {
		
	}
	
	/**
	 * Constuctor
	 * @param id
	 * @param name
	 */
	public TipoCorriente(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	//Getters and Setters
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
