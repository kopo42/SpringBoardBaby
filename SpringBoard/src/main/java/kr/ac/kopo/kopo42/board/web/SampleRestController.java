package kr.ac.kopo.kopo42.board.web;

import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.kopo42.board.domain.Sample;
import kr.ac.kopo.kopo42.board.repository.SampleRepository;

@RestController
public class SampleRestController {
	private static final Logger logger = LoggerFactory.getLogger(SampleRestController.class);
			
		@Autowired
		private SampleRepository sampleRepositoy;
		
		@RequestMapping("/api/sample/findOne")
		public Sample findOne(@RequestParam HashMap<String, String> map){
			Long id = Long.parseLong(map.get("id"));
			String title = map.get("title");
			logger.info("id: "  + id);
			logger.info("title: " + title);
			return sampleRepositoy.findById(id).get();
		}
}
	
		

