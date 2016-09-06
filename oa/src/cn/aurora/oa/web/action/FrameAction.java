package cn.aurora.oa.web.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
@Scope("prototype")
public class FrameAction extends ActionSupport {
	private static final String FRAME_LEFT="left";
	private static final String FRAME_RIGHT="right";
	private static final String FRAME_BOTTOM="bottom";
	private static final String FRAME_TOP="top";
	
	
	public String left() {
		return FRAME_LEFT;
	}

	public String right() {
		return FRAME_RIGHT;
	}

	public String bottom() {
		return FRAME_BOTTOM;
	}

	public String top() {
		return FRAME_TOP;
	}

}
