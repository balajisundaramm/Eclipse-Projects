package java_expert_practise;

public class Movies implements Comparable<Movies> {
	private String name;
	private int id;
	private int year;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + year;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movies other = (Movies) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (year != other.year)
			return false;
		return true;
	}
	public Movies( int id,String name,int year) {
		super();
		this.name = name;
		this.id = id;
		this.year = year;
	}
	@Override
	public int compareTo(Movies o) {
		
		return this.year-o.year;
	}
	@Override
	public String toString() {
		return "Movies [name=" + name + ", id=" + id + ", year=" + year + "]";
	}

}
