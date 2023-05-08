package com.klu.demo;
import com.klu.demo.ImageRepository;
import com.klu.demo.Image;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;
@Service
public class MyService 
{
	 private static final Logger logger = LoggerFactory.getLogger("MyService.class");
	    @Autowired
	    private ImageRepository dao;

	    public int saveImage(Image model) {
	        try {
	            dao.save(model);
	            return 1;
	        } catch (Exception e) {
	            logger.error("ERROR", e);
	            return 0;
	        }
	    }

	    public Image getImages(Long id) {
	        Optional findById = dao.findById(id);
	        if (findById.isPresent()) {
	           Image getImageDetails = (Image) findById.get();
	            logger.info("id= " + getImageDetails.getId() + " name= " + getImageDetails.getName());
	            return getImageDetails;
	        } else {
	            return null;
	        }
	    } 
}
