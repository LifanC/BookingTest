package demo.project.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import demo.project.entity.*;

@RestController
public class BookingController {
	@Autowired
	private BookingRepository bookingRepository;
	BookingMember bm = new BookingMember();
	MemberData md=new MemberData("未登入");
	@GetMapping("index")
	public ModelAndView index() {
		ModelAndView view = new ModelAndView("indexFirstPage");
		view.addObject("member", md);
		return view;
	}

	@PostMapping("register")
	public ModelAndView register(BookingMember bookingMember) {
		List<BookingMember> data = bookingRepository.queryByEmail(bookingMember.getEmail());
		ModelAndView view = null;
		if (data.size() == 0) {
			bookingRepository.save(bookingMember);
			bm.setClientName("成功註冊");
			System.out.println(bm.getClientName());
			view = new ModelAndView("clientRegister");
		} else if (data.size() >= 1) {
			bm.setClientName("重複註冊");
			System.out.println(bm.getClientName());
			view = new ModelAndView("clientRegister");
		}
		view.addObject("clientData", bm);
		return view;
	}
	
	@PostMapping("login")
	public ModelAndView login(BookingMember bookingMember) {
		List<BookingMember> data = bookingRepository.queryByEmail(bookingMember.getEmail());
		ModelAndView view = null;
		String tf = null;
		for (BookingMember e : data) {
			if(bookingMember.getEmail()!="" && bookingMember.getEmail()!=null &&
					e.getEmail().equals(bookingMember.getEmail()) &&
					e.getPhoneNumber().equals(bookingMember.getPhoneNumber())) {
				tf="true";
				md.setClientName(e.getClientName());
			}else {
				tf="false";
				md.setClientName("登入失敗");
			}
		}
		switch(tf) {
		case "true": 
			bm.setClientName("登入成功");
			System.out.println(bm.getClientName());
			view=new ModelAndView("clientLogin");
            break; 
		case "false":
			bm.setClientName("登入失敗");
			System.out.println(bm.getClientName());
			view=new ModelAndView("clientLogin");
            break; 
		}
			view.addObject("loginData", bm);
			return view;
	}

	@PostMapping("find")
	public ModelAndView find(BookingMember bookingMember) {
		List<BookingMember> data = bookingRepository.queryByEmail(bookingMember.getEmail());
		ModelAndView view = new ModelAndView("sreachDone");
		System.out.println(bm.getClientName());
		view.addObject("findData", data);
		return view;
	}

	@PostMapping("set")
	public ModelAndView set(BookingMember bookingMember) {
		List<BookingMember> data = bookingRepository.queryByEmail(bookingMember.getEmail());
		for (BookingMember e : data) {
			bookingMember.setId(e.getId());
		}
		if (data.size() == 1) {
			bookingRepository.deleteById(bookingMember.getId());
			bookingRepository.save(bookingMember);
			bm.setClientName("修改完成");
			System.out.println(bm.getClientName());
		}else if (data.size() == 0) {
			bm.setClientName("修改失敗");
			System.out.println(bm.getClientName());
		}
		ModelAndView view = new ModelAndView("clientset");
		view.addObject("clientData", bm);
		return view;

	}
}
