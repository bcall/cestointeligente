package ar.com.itr.cestointeligente.entities;

public class AutocompleteJSON {

	private String label;
	private String value;

	public AutocompleteJSON(String label, String value) {
		this.label = label;
		this.value = value;
	}

	public AutocompleteJSON() {

	}

	public String getLabel() {
		return label;
	}

	public void setId(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
