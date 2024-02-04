package vavi.util.archive.unar.xadmaster;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;
/**
 * *<br>
 *    hook related stuff                                                 *<br>
 *                                                                       *<br>
 * **********************************************************************<br>
 * <i>native declaration : /Frameworks/XADMaster.framework/Versions/A/Headers/xadmaster.h:222</i><br>
 * This file was autogenerated by <a href="http://jnaerator.googlecode.com/">JNAerator</a>,<br>
 * a tool written by <a href="http://ochafik.com/">Olivier Chafik</a> that <a href="http://code.google.com/p/jnaerator/wiki/CreditsAndLicense">uses a few opensource projects.</a>.<br>
 * For help, please visit <a href="http://nativelibs4java.googlecode.com/">NativeLibs4Java</a> , <a href="http://rococoa.dev.java.net/">Rococoa</a>, or <a href="http://jna.dev.java.net/">JNA</a>.
 */
public class xadHookParam extends Structure {
	/** C type : xadUINT32 */
	public int xhp_Command;
	/** C type : xadSignSize */
	public long xhp_CommandData;
	/** C type : xadPTR */
	public Pointer xhp_BufferPtr;
	/** C type : xadSize */
	public long xhp_BufferSize;
	/**
	 * current seek position<br>
	 * C type : xadSize
	 */
	public long xhp_DataPos;
	/** C type : xadPTR */
	public Pointer xhp_PrivatePtr;
	/**
	 * allows to transport tags to hook (V9)<br>
	 * C type : xadTAGPTR
	 */
	public vavi.util.archive.unar.xadmaster.TagItem.ByReference xhp_TagList;
	public xadHookParam() {
		super();
	}
	protected List<String> getFieldOrder() {
		return Arrays.asList("xhp_Command", "xhp_CommandData", "xhp_BufferPtr", "xhp_BufferSize", "xhp_DataPos", "xhp_PrivatePtr", "xhp_TagList");
	}
	/**
	 * @param xhp_Command C type : xadUINT32<br>
	 * @param xhp_CommandData C type : xadSignSize<br>
	 * @param xhp_BufferPtr C type : xadPTR<br>
	 * @param xhp_BufferSize C type : xadSize<br>
	 * @param xhp_DataPos current seek position<br>
	 * C type : xadSize<br>
	 * @param xhp_PrivatePtr C type : xadPTR<br>
	 * @param xhp_TagList allows to transport tags to hook (V9)<br>
	 * C type : xadTAGPTR
	 */
	public xadHookParam(int xhp_Command, long xhp_CommandData, Pointer xhp_BufferPtr, long xhp_BufferSize, long xhp_DataPos, Pointer xhp_PrivatePtr, vavi.util.archive.unar.xadmaster.TagItem.ByReference xhp_TagList) {
		super();
		this.xhp_Command = xhp_Command;
		this.xhp_CommandData = xhp_CommandData;
		this.xhp_BufferPtr = xhp_BufferPtr;
		this.xhp_BufferSize = xhp_BufferSize;
		this.xhp_DataPos = xhp_DataPos;
		this.xhp_PrivatePtr = xhp_PrivatePtr;
		this.xhp_TagList = xhp_TagList;
	}
	public xadHookParam(Pointer peer) {
		super(peer);
	}
	public static class ByReference extends xadHookParam implements Structure.ByReference {
		
	};
	public static class ByValue extends xadHookParam implements Structure.ByValue {
		
	};
}
