package vavi.util.archive.xad.xadmaster;
import com.sun.jna.Callback;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.PointerByReference;

import java.util.Collections;
import java.util.List;
/**
 * a standard callback system<br>
 * <i>native declaration : /Frameworks/XADMaster.framework/Versions/A/Headers/xadmaster.h:19</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class Hook extends Structure {
	/**
	 * data parameter always passed to callback<br>
	 * C type : xadPTR*
	 */
	public PointerByReference h_Data;
	/** <i>native declaration : /Frameworks/XADMaster.framework/Versions/A/Headers/xadmaster.h</i> */
	public interface xadUINT32_callback extends Callback {
		int apply();
	};
	public Hook() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Collections.singletonList("h_Data");
	}
	/**
	 * @param h_Data data parameter always passed to callback<br>
	 * C type : xadPTR*
	 */
	public Hook(PointerByReference h_Data) {
		super();
		this.h_Data = h_Data;
	}
	public Hook(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends Hook implements Structure.ByReference {
	}
	public static class ByValue extends Hook implements Structure.ByValue {
	}
}