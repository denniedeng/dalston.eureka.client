package cloud.dalston.eureka.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/discovery")
public class DiscoveryController {
	
    @Autowired
    DiscoveryClient discoveryClient;
	
	@RequestMapping(value = "/calculate" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
		//打印服务清单
		String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
		
        Integer r = a + b;
        return r;
    }
	
	/**
	 * 
	 * @param file
	 * @return
	 */
	@RequestMapping(value = "/uploadFile", method=RequestMethod.POST,consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String handleFileUpload(@RequestPart(value = "file") MultipartFile file) {
		System.out.println("file size is "+file.getSize());
        return file.getName();
    }
}
