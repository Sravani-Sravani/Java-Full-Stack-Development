package com.klu.demo;
import java.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class ImageController
{
	 private static final Logger logger = LoggerFactory.getLogger("ImageController.class");
	    @Autowired
	    private MyService myService;

	    @GetMapping("/index")
	    public ModelAndView test() {
	    	ModelAndView mv=new ModelAndView();
	        mv.setViewName("index");
	        return mv;
	    }

	    @PostMapping("/fileupload")
	    public String fileUpload(@RequestParam("name") String name, @RequestParam("file") MultipartFile file) {
	        try {
	            logger.info("Name= " + name);
	            byte[] image = file.getBytes();
	            Image model = new Image(name, image);
	            int saveImage = myService.saveImage(model);
	            if (saveImage == 1) {
	                return "success";
	            } else {
	                return "error";
	            }
	        } catch (Exception e) {
	            logger.error("ERROR", e);
	            return "error";
	        }
	    }

	    @GetMapping("/getDetail/{id}")
	    public String getDbDetils(@PathVariable String id, Model model) {
	        try {
	            logger.info("Id= " + id);
	            Image imagesObj = myService.getImages(Long.parseLong(id));
	            model.addAttribute("id", imagesObj.getId());
	            model.addAttribute("name", imagesObj.getName());
	            byte[] encode = java.util.Base64.getEncoder().encode(imagesObj.getImage());
	            model.addAttribute("image", new String(encode, "UTF-8"));
	            return "imagedetails";
	        } catch (Exception e) {
	            logger.error("Error", e);
	            model.addAttribute("message", "Error in getting image");
	            return "redirect:/";
	        }
	    }
}
