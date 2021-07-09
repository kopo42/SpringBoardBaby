package kr.ac.kopo.kopo42.board.service;

public interface SampleService {
	String test();
	String testAop();
	
	//Transactional
	String testNoTransactional();
	String testTransactional();
}
