package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Admin;
import com.example.demo.model.BankDetails;
import com.example.demo.model.Category;
import com.example.demo.model.Medicine;
import com.example.demo.model.OrderSummary;
import com.example.demo.model.Status;
import com.example.demo.model.User;
import com.example.demo.service.AdminDAO;
import com.example.demo.service.BankDAO;
import com.example.demo.service.CategoryDAO;
import com.example.demo.service.MedicineDAO;
import com.example.demo.service.OrderDAO;
import com.example.demo.service.StatusDAO;
import com.example.demo.service.UserDAO;

@Controller
public class MainController {

	@Autowired
	UserDAO udao;
	@Autowired
	AdminDAO adao;
	@Autowired
	BankDAO bdao;
	@Autowired
	MedicineDAO mdao;
	@Autowired
	OrderDAO odao;
	@Autowired
	CategoryDAO cdao;
	@Autowired
	StatusDAO sdao;
	
	
	@RequestMapping("/showMedAdmin")
	public ModelAndView showMedAdmin(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<Medicine> list=mdao.findAllMeds();
		mv.addObject("list",list);
		
		List<Category> clist=cdao.findAllCat();
		mv.addObject("clist",clist);
		
		List<Status> slist=sdao.findAllSt();
		mv.addObject("slist",slist);
		
		mv.setViewName("showMedToAdmin.jsp");
		return mv;
	}
	@RequestMapping("/showMeduser")
	public ModelAndView showMeduser(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<Medicine> list=mdao.showToUser();
		mv.addObject("list",list);
		
		List<Category> clist=cdao.findAllCat();
		mv.addObject("clist",clist);
		
		List<Status> slist=sdao.findAllSt();
		mv.addObject("slist",slist);
		
		mv.setViewName("showMedTouser.jsp");
		return mv;
	}
	@RequestMapping("/cart")
	public ModelAndView cart(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Medicine m=new Medicine();
		int id=Integer.parseInt(request.getParameter("mid"));
		Medicine mm=mdao.findById(id);
		String name=mm.getMName();
		int price=mm.getMPrice();
		OrderSummary or=new OrderSummary();
		or.setMedName(name);
		or.setMedPrice(price);
		OrderSummary or2=odao.insert(or);
		List<OrderSummary> or1=odao.getAll();
		mv.addObject("or1",or1);
		mv.setViewName("cartgo.jsp");
		return mv;
	}
	@RequestMapping("/bank")
	public ModelAndView bank(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		int price=Integer.parseInt(request.getParameter("price"));
		System.out.println(price);
		BankDetails bd=new BankDetails();
		bd.setBid(Integer.parseInt(request.getParameter("bid")));
		int bid=bd.getBid();
		int balance=bdao.getBalance(bid);
		
		if(balance>price) {
			
			mv.setViewName("paysuccess.jsp");
		}
		else {
			mv.setViewName("payfail.jsp");
		}
		return mv;
	}
	
	@RequestMapping("/")
	public ModelAndView homepage(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}
	
	@RequestMapping("/addMedicine")
	public ModelAndView addMed(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Medicine m=new Medicine();
		m.setMName(request.getParameter("mname"));
		m.setMPrice(Integer.parseInt(request.getParameter("mprice")));
		m.setCategory(request.getParameter("categoryName"));
		m.setDescription(request.getParameter("mdesc"));
		m.setStatus(request.getParameter("statusName"));
		m.setOffer(request.getParameter("moffer"));
		Medicine mm=mdao.insert(m);
		if(mm!=null) {
			mv.setViewName("success.jsp");
		}
		else {
			mv.setViewName("fail.jsp");
		}
		return mv;
	}
	@RequestMapping("/editMed")
	public ModelAndView editMM(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		int mid=Integer.parseInt(request.getParameter("mid"));
		mv.addObject("mid",mid);
		
		List<Category> clist=cdao.findAllCat();
		mv.addObject("clist",clist);
		
		List<Status> slist=sdao.findAllSt();
		mv.addObject("slist",slist);
		
		mv.setViewName("editmed1.jsp");
		return mv;
	
	}
	
	@RequestMapping("/searchMed")
	public ModelAndView searchMed(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		String keyword=request.getParameter("keyword");
		System.out.println(keyword);
	List<Medicine> list=mdao.searchByNameOrCategory(keyword);
	mv.addObject("list",list);

	
	mv.setViewName("searchList.jsp");
		return mv;
	}

	@RequestMapping("/searchMeduser")
	public ModelAndView searchMeduser(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		String keyword=request.getParameter("keyword");
		System.out.println(keyword);
	List<Medicine> list=mdao.searchByNameOrCategoryuser(keyword);
	mv.addObject("list",list);

	
	mv.setViewName("searchListuser.jsp");
		return mv;
	}
	
	@RequestMapping("/filterByCategory")
	public ModelAndView filterMed(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		String keyword=request.getParameter("categoryName");
		System.out.println(keyword);
	List<Medicine> list=mdao.filterByCat(keyword);
	mv.addObject("list",list);
	mv.setViewName("searchList.jsp");
		return mv;
	}
	@RequestMapping("/filterByCategoryuser")
	public ModelAndView filterMeduser(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		String keyword=request.getParameter("categoryName");
		System.out.println(keyword);
	List<Medicine> list=mdao.filterByCatuser(keyword);
	mv.addObject("list",list);
	mv.setViewName("searchListuser.jsp");
		return mv;
	}
	
	@RequestMapping("/sortList")
	public ModelAndView sortMed(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		String keyword=request.getParameter("listType");
		System.out.println(keyword);
	if(keyword.equals("ASC")) {
		List<Medicine> list=mdao.getAllAsc();
		mv.addObject("list",list);
		mv.setViewName("searchList.jsp");
		}
	else {
		List<Medicine> list=mdao.getAllDesc();
		mv.addObject("list",list);
		mv.setViewName("searchList.jsp");
	}
		return mv;
	}
	@RequestMapping("/sortListuser")
	public ModelAndView sortMeduser(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		String keyword=request.getParameter("listType");
		System.out.println(keyword);
	if(keyword.equals("ASC")) {
		List<Medicine> list=mdao.getAllAscuser();
		mv.addObject("list",list);
		mv.setViewName("searchListuser.jsp");
		}
	else {
		List<Medicine> list=mdao.getAllDescuser();
		mv.addObject("list",list);
		mv.setViewName("searchListuser.jsp");
	}
		return mv;
	}

	@RequestMapping("/editMedicine")
	public ModelAndView editMed(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Medicine m=new Medicine();
		m.setMid(Integer.parseInt(request.getParameter("mid")));
		m.setMName(request.getParameter("mname"));
		m.setMPrice(Integer.parseInt(request.getParameter("mprice")));
		m.setCategory(request.getParameter("categoryName"));
		m.setDescription(request.getParameter("mdesc"));
		m.setStatus(request.getParameter("statusName"));
		m.setOffer(request.getParameter("moffer"));
		Medicine mm=mdao.update(m);
		if(mm!=null) {
			mv.setViewName("success.jsp");
		}
		else {
			mv.setViewName("fail.jsp");
		}
		
		
		
		return mv;
	}
	
	
	
	@RequestMapping("/checkadmin")
	public ModelAndView chkAdmin(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		Admin e=new Admin();
		e.setAusername(request.getParameter("adusnm"));
		String user=e.getAusername();
		e.setApassword(request.getParameter("adpass"));
		String pass=e.getApassword();
		String pass1=adao.getPassword(user);
		if(pass1!=null) {
			if(pass.equals(pass1)) {
				List<Category> clist=cdao.findAllCat();
				mv.addObject("clist",clist);
				
				List<Status> slist=sdao.findAllSt();
				mv.addObject("slist",slist);

				
				mv.setViewName("MedicineDetailAd.jsp");
			}
			else {
				String msg="Check credentials and try again..Incorrect Password!!";
				mv.addObject("msg",msg);
				mv.setViewName("adminlogin1.jsp");
			}
			
		}
		else {
			String msg="Not a registered admin!!Try Again..";
			mv.addObject("msg",msg);
			mv.setViewName("adminlogin1.jsp");
		}
		return mv;
	}	
	
	@RequestMapping("/checkuser")
	public ModelAndView chkUser(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		User u= new User();
		u.setUusername(request.getParameter("uusnm"));
		String username=u.getUusername();
		u.setUpassword(request.getParameter("upass"));
		String password=u.getUpassword();
		String password1=udao.userPwd(username);
		String cname=udao.findtheName(username);
		if(password1!=null) {
			if(password1.equals(password)) {
				String msg="Welcome to Medicare "+cname+"!!";
				mv.addObject("msg",msg);
				mv.addObject("cname",cname);
				mv.setViewName("showMedtouser1.jsp");
			}
			else {
				String msg="Check credentials and try again..Incorrect Password!!";
				mv.addObject("msg",msg);
				mv.setViewName("userlogin1.jsp");
			}
			
		}
		else {
			String msg="Not registered!!Sign Up First..";
			mv.addObject("msg",msg);
			mv.setViewName("userlogin1.jsp");
		}
		
	
	return mv;
	}
	
	@RequestMapping("/insertuser")
	public ModelAndView insertUser(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		User u= new User();
		u.setU_fname(request.getParameter("ufname"));
		String cname=u.getU_fname();
		u.setU_lname(request.getParameter("ulname"));
		u.setEmail(request.getParameter("uemail"));
		u.setUusername(request.getParameter("uusnm"));
		u.setUpassword(request.getParameter("upass"));
		
		User uu=udao.insert(u);
		if(uu!=null) {
			String msg="Welcome to Kitchen-Story "+cname+"..Order your food from here!!";
			mv.addObject("msg",msg);
			mv.addObject("cname",cname);
			mv.setViewName("showMedtouser1.jsp");
		}
		return mv;
	}
	
	
}
