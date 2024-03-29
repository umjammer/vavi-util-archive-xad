package vavi.util.archive.xad.xadmaster;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Collections;
import java.util.List;
/**
 * library base structure
 * <i>native declaration : /Frameworks/XADMaster.framework/Versions/A/Headers/xadmaster.h:35</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class xadMasterBase extends Structure {
	/** C type : xadPTR */
	public Pointer dummy;
	public xadMasterBase() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Collections.singletonList("dummy");
	}
	/** @param dummy C type : xadPTR */
	public xadMasterBase(Pointer dummy) {
		super();
		this.dummy = dummy;
	}
	public static class ByReference extends xadMasterBase implements Structure.ByReference {
	}
	public static class ByValue extends xadMasterBase implements Structure.ByValue {
	}
}
