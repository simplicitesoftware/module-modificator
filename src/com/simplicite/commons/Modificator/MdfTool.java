package com.simplicite.commons.Modificator;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;
import com.simplicite.objects.System.Module;

/**
 * Shared code MdfTool
 */
public class MdfTool implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	public static void postLoad(ObjectDB obj){
		obj.setDefaultSearchSpec(getMdfSearchSpec(obj.getGrant()));
	}
	
	public static void preSave(ObjectDB obj){
		obj.setFieldValue("row_module_id", getDestModuleId(obj.getGrant()));		
	}
	
	public static String postSave(ObjectDB obj){
		Module mdl = (Module) obj.getGrant().getTmpObject("Module");
		synchronized(mdl){
			mdl.select(getDestModuleId(obj.getGrant()));
			mdl.exportToXML();
		}
		return Message.formatWarning("MDF_WARN_NOTIFY", null, null);
	}
	
	// creates module if not existant
	private static String getDestModuleId(Grant g){
		return ModuleDB.getModuleId(g.getParameter("MDF_SAVE_MODULE"), true);
	}
	
	private static String getMdfSearchSpec(Grant g){
		String visibleModules = g.getParameter("MDF_MODULES");
		if(Tool.isFalse(visibleModules))
			return "1=0";
		else{
			List<String> mdl = new ArrayList(Arrays.asList(visibleModules.split(",")));
			mdl.add(g.getParameter("MDF_SAVE_MODULE"));
			AppLog.info(mdl.toString(), Grant.getSystemAdmin());
			return 
				"t_row_module_id.mdl_name in ('"
				+ String.join("','", mdl)
				+ "')";
		}
	}
}
