package org.phish.model;

public class AttributeDTO {

	private String name;

	private int remeberCounter;
	private int understandCounter;
	private int applyCounter;
	private int analyzeCounter;
	private int evaluateCounter;
	private int createCounter;
	
	
	
	public AttributeDTO() {
		super();
	}
	public AttributeDTO(String name, int remeberCounter, int understandCounter, int applyCounter, int analyzeCounter,
			int evaluateCounter, int createCounter) {
		super();
		this.name = name;
		this.remeberCounter = remeberCounter;
		this.understandCounter = understandCounter;
		this.applyCounter = applyCounter;
		this.analyzeCounter = analyzeCounter;
		this.evaluateCounter = evaluateCounter;
		this.createCounter = createCounter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRemeberCounter() {
		return remeberCounter;
	}
	public void setRemeberCounter(int remeberCounter) {
		this.remeberCounter = remeberCounter;
	}
	public int getUnderstandCounter() {
		return understandCounter;
	}
	public void setUnderstandCounter(int understandCounter) {
		this.understandCounter = understandCounter;
	}
	public int getApplyCounter() {
		return applyCounter;
	}
	public void setApplyCounter(int applyCounter) {
		this.applyCounter = applyCounter;
	}
	public int getAnalyzeCounter() {
		return analyzeCounter;
	}
	public void setAnalyzeCounter(int analyzeCounter) {
		this.analyzeCounter = analyzeCounter;
	}
	public int getEvaluateCounter() {
		return evaluateCounter;
	}
	public void setEvaluateCounter(int evaluateCounter) {
		this.evaluateCounter = evaluateCounter;
	}
	public int getCreateCounter() {
		return createCounter;
	}
	public void setCreateCounter(int createCounter) {
		this.createCounter = createCounter;
	}

	
	
		
	
	
}
