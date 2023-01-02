package demo.project.entity;

public class Bo {
	private Integer idbo;
	private String name;
	private String add;

	public Bo() {}

	public Bo(String add) {
		this.add = add;
	}

	public Bo(String name, String add) {
		this.add = add;
	}

	public Integer getId() {
		return idbo;
	}

	public void setId(Integer id) {
		this.idbo = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}

	

}
