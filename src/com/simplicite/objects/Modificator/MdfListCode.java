package com.simplicite.objects.Modificator;

import java.util.*;
import com.simplicite.util.*;
import com.simplicite.util.tools.*;
import com.simplicite.objects.System.FieldListCode;
import com.simplicite.commons.Modificator.MdfTool;

/**
 * Business object MdfListCode
 */
public class MdfListCode extends FieldListCode {
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
		return MdfTool.postSave();
	}
}
