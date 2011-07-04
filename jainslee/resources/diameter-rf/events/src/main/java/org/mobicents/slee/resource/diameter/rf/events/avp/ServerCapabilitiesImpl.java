package org.mobicents.slee.resource.diameter.rf.events.avp;

import net.java.slee.resource.diameter.rf.events.avp.ServerCapabilities;

import org.mobicents.slee.resource.diameter.base.events.avp.GroupedAvpImpl;

/**
 * <br>Project: mobicents-diameter-server
 * <br>3:01:19 AM Jun 3, 2009 
 * <br>
 *
 * ServerCapabilitiesImpl.java
 *
 * @author <a href="mailto:brainslog@gmail.com"> Alexandre Mendonca </a>
 */
public class ServerCapabilitiesImpl extends GroupedAvpImpl implements ServerCapabilities {

  public ServerCapabilitiesImpl() {
    super();
  }

  /**
   * @param code
   * @param vendorId
   * @param mnd
   * @param prt
   * @param value
   */
  public ServerCapabilitiesImpl(int code, long vendorId, int mnd, int prt, byte[] value) {
    super(code, vendorId, mnd, prt, value);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.ServerCapabilities#getMandatoryCapability()
   */
  public long getMandatoryCapability() {
    return getAvpAsUnsigned32(DiameterRfAvpCodes.MANDATORY_CAPABILITY, DiameterRfAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.ServerCapabilities#getOptionalCapability()
   */
  public long getOptionalCapability() {
    return getAvpAsUnsigned32(DiameterRfAvpCodes.OPTIONAL_CAPABILITY, DiameterRfAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.ServerCapabilities#getServerName()
   */
  public String getServerName() {
    return getAvpAsUTF8String(DiameterRfAvpCodes.SERVER_NAME, DiameterRfAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.ServerCapabilities#hasMandatoryCapability()
   */
  public boolean hasMandatoryCapability() {
    return hasAvp(DiameterRfAvpCodes.MANDATORY_CAPABILITY, DiameterRfAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.ServerCapabilities#hasOptionalCapability()
   */
  public boolean hasOptionalCapability() {
    return hasAvp(DiameterRfAvpCodes.OPTIONAL_CAPABILITY, DiameterRfAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.ServerCapabilities#hasServerName()
   */
  public boolean hasServerName() {
    return hasAvp(DiameterRfAvpCodes.SERVER_NAME, DiameterRfAvpCodes.TGPP_VENDOR_ID);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.ServerCapabilities#setMandatoryCapability(long)
   */
  public void setMandatoryCapability( long mandatoryCapability ) {
    addAvp(DiameterRfAvpCodes.MANDATORY_CAPABILITY, DiameterRfAvpCodes.TGPP_VENDOR_ID, mandatoryCapability);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.ServerCapabilities#setOptionalCapability(long)
   */
  public void setOptionalCapability( long optionalCapability ) {
    addAvp(DiameterRfAvpCodes.OPTIONAL_CAPABILITY, DiameterRfAvpCodes.TGPP_VENDOR_ID, optionalCapability);
  }

  /* (non-Javadoc)
   * @see net.java.slee.resource.diameter.rf.events.avp.ServerCapabilities#setServerName(String)
   */
  public void setServerName( String serverName ) {
    addAvp(DiameterRfAvpCodes.SERVER_NAME, DiameterRfAvpCodes.TGPP_VENDOR_ID, serverName);
  }

}