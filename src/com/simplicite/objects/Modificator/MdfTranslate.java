package com.simplicite.objects.Modificator;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;
import com.simplicite.objects.System.Translate;
import com.simplicite.commons.Modificator.MdfTool;

/**
 * Business object MdfTranslate
 */
public class MdfTranslate extends Translate {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void postLoad() {
		MdfTool.postLoad(this);
		super.postLoad();
	}
	
	@Override
	public String preSave() {
		MdfTool.preSave(this);
		return super.preSave();
	}
	
	@Override
	public String postSave() {
		return MdfTool.postSave(this);
	}
	
	@Override
	public String[] getTargetObject(String rowId, String[] row) {
		if("1".equals(getParameter("_UI_EDIT_TEMPLATE_"))) // Template editor
			return null;
		if(rowId.equals(ObjectField.DEFAULT_ROW_ID))
			return null;
		if(row==null && (rowId.equals(getRowId()) || select(rowId)))
			row = getValues();
		if(row!=null && "F".equals(row[getFieldIndex("tsl_type")]))
			return new String[]{"MdfTranslateField", "the_ajax_MdfTranslateField", row[getFieldIndex("row_id")] };
		
		return null;		
	}
}
