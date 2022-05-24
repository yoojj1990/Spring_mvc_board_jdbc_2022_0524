package com.yjj.MVCBoard.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.yjj.MVCBoard.dao.BDao;
import com.yjj.MVCBoard.dto.BDto;

public class BContentCommand implements BCoammand {

	@Override
	public void excute(Model model) {
		// TODO Auto-generated method stub

		Map<String, Object> map = model.asMap();
		
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String bid = request.getParameter("bid");
		
		BDao dao = new BDao();
		
		BDto dto = dao.content_view(bid);
		
		
		model.addAttribute("content", dto);
		
		
	}

}
