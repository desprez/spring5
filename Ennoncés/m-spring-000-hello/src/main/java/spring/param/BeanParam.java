package spring.param;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class BeanParam {

	@Value("#{'${param1}'}")
	private String p1;

	@Value("#{config2.config1param1}")
	private String p2;

	@Value("#{propXmlId['key.in.xml.integer']}")
	private Integer myInteger;

	public void printParam() {
		System.out.println(this.toString());
	}

	@Override
	public String toString() {
		return "BeanParam [p1=" + p1 + ", p2=" + p2 + ", myInteger=" + myInteger + "]";
	}

}
