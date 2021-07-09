package kr.ac.kopo.kopo42.board.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.ac.kopo.kopo42.board.domain.BoardItem;
import kr.ac.kopo.kopo42.board.repository.BoardItemRepository;
import kr.ac.kopo.kopo42.board.repository.BoardItemSpecs;
import kr.ac.kopo.kopo42.board.service.BoardItemService;

@Controller
@RequestMapping("/boardItem/*")
public class BoardItemController {
	
	@Autowired
	private BoardItemRepository boardItemRepository;
	
	@Inject
	private BoardItemService boardItemService;
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void getList() {
	}
	
	@RequestMapping(value="/insert", method = RequestMethod.GET)
	public void getWrite() throws Exception{
		
	}
	@RequestMapping(value="/insert", method = RequestMethod.POST)
	public String PostWrite(BoardItem boardItem) throws Exception{
		boardItemService.write(boardItem);
		return "redirect:/boardItem/list";
	}
	
//	@RequestMapping(value = "/list")
//	@ResponseBody
//	public List<BoardItem> boardItemList(Model model) {
//		return boardItemRepository.findAll();
//	}
	
	@RequestMapping(value = "/view")
	@ResponseBody
	public BoardItem viewTest(Model model) {
		List <BoardItem> list = boardItemRepository.findAll();
		System.out.println(list.size());
		return list.get(0);
	}
	
	@RequestMapping(value = "/pageable")
	@ResponseBody
	public List<BoardItem> pageable(Model model){
		PageRequest pageable = PageRequest.of(0, 2);
		Page<BoardItem> page = boardItemRepository.findAll(pageable);
		
		return page.getContent();
	}
	
	@RequestMapping(value = "/findOne")
	@ResponseBody
	public Optional<BoardItem> Search(Model model){
		return boardItemRepository.findOneByTitle("boardItemTitle4");
	}
	
	@RequestMapping(value = "/search")
	@ResponseBody
	public void Search() {
		Map<String, Object> filter = new HashMap<String, Object>();
		filter.put("title", "t2");
		
		PageRequest pageable = PageRequest.of(0, 10);
		Page<BoardItem> page = boardItemRepository.findAll(BoardItemSpecs.search(filter), pageable);
		
		for(BoardItem bItem: page) {
			System.out.println(bItem.getTitle());
		}
	}
}
