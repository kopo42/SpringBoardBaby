package kr.ac.kopo.kopo42.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.kopo42.board.domain.Sample;
import kr.ac.kopo.kopo42.board.repository.SampleRepository;
import kr.ac.kopo.kopo42.board.repository.SampleSpecs;
import kr.ac.kopo.kopo42.board.service.SampleService;

@Controller
public class SampleController {
	
	private static final Logger logger = LoggerFactory.getLogger(SampleController.class);
	
	@Autowired
	private SampleRepository sampleRepository;
	
	@Autowired
	private SampleService sampleService;
	
	@RequestMapping(value  ="/sample/noTransactional")
	@ResponseBody
	public String noTransactional() {
		return sampleService.testNoTransactional();
	}
	@RequestMapping(value  ="/sample/transactional")
	@ResponseBody
	public String transactional() {
		return sampleService.testTransactional();
	}
	
	@RequestMapping(value = "/sample/noAop")
	@ResponseBody
	public String noAop() {
		return sampleService.test();
	}
	@RequestMapping(value = "/sample/aop")
	@ResponseBody
	public String aop() {
		return sampleService.testAop();
	}
	

	@RequestMapping(value = "/sample/list")
	@ResponseBody
	public List<Sample> list(Model model){
		return sampleRepository.findAll();
	}
	
	@RequestMapping(value = "/sample/pageable")
	@ResponseBody
	public List<Sample> pageable(Model model){
		PageRequest pageable = PageRequest.of(0, 2);
		Page<Sample> page = sampleRepository.findAll(pageable);
		
		return page.getContent();
	}
	
	@RequestMapping(value = "/sample/findOne")
	@ResponseBody
	public Optional<Sample> Search(Model model){
		return sampleRepository.findOneByTitle("t2");
	}
	
	@RequestMapping(value = "/sample/search")
	@ResponseBody
	public void Search() {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("title", "t2");
		
		PageRequest pageable = PageRequest.of(0, 10);
		Page<Sample> page = sampleRepository.findAll(SampleSpecs.search(filter), pageable);
		
		for(Sample s: page) {
			System.out.println(s.getTitle());
		}
	}
}
