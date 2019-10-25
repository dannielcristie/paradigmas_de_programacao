package br.ufma.ecp.paradigmas.javafuncional;

public class Pixel {
	
	
	public Pixel(int x, int y, Integer value) {
		super();
		this.x = x;
		this.y = y;
		this.value = value;
	}
	private int x, y;
	private Integer value;
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return "Pixel [x=" + x + ", y=" + y + ", value=" + value + "]";
	}
	
	public void printValue() {
		System.out.println(value);
	}

}
