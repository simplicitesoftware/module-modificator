package com.simplicite.commons.Modificator;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;

/**
 * Shared code MdfTool
 */
public class MdfTool implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	public static String getMdfSearchSpec(Grant g){
		String visibleModules = g.getParameter("MDF_MODULES");
		if(Tool.isFalse(visibleModules))
			return "1=0";
		else
			return 
				"t_row_module_id.mdl_name in ('"
				+ String.join("','", Arrays.asList(visibleModules.split(",")))
				+ "')";
	}
}
