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
		setDefaultSearchSpec(MdfTool.getMdfSearchSpec(getGrant()));
		super.postLoad();
	}
	
	@Override
	public String postUpdate() {
		return Message.formatWarning("MDF_WARN_NOTIFY", null, null);
	}
}
