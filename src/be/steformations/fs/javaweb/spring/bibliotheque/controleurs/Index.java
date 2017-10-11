package be.steformations.fs.javaweb.spring.bibliotheque.controleurs;

@org.springframework.stereotype.Controller
@org.springframework.context.annotation.Scope("request")
public class Index {

	public Index(){
		
		
	}
	
	@org.springframework.web.bind.annotation.RequestMapping("index")
	public String showIndex(){			
		return "/index.jsp";
	}
	
	
}
