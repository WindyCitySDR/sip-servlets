/*
 * JBoss, Home of Professional Open Source
 * Copyright 2008, Red Hat Middleware LLC, and individual contributors
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.mobicents.javax.servlet.sip;

/**
 * Interface Extension that adds extra features to the JSR 289 ProxyBranch interface.</br>
 * It adds the following capabilities : 
 * 
 * <ul>
 * 		<li>
 * 			Allows for applications to set a timeout on 1xx responses as JSR 289 defines a timeout only for final responses.
 * 		</li>
 * </ul>
 * 
 * 
 * @author jean.deruelle@gmail.com
 * @since 1.3
 */
public interface ProxyBranchExt {
	/**
	 * Sets the search timeout value for this ProxyBranch object for 1xx responses.
	 * This is the amount of time, in seconds, the container waits for an informational response when proxying on this branch.</br>
	 * This method can be used to override the default timeout the branch obtains from the {@link ProxyExt#setProxy1xxTimeout(int)} object
	 * <ul>
	 * 	<li> 
	 * 		If the proxy is sequential, when the timer expires and no 1xx response nor final response has been received,
	 * 		the container CANCELs the current branch and proxies to the next element in the target set.
	 * 	</li>
	 *  <li> 
	 * 		In case the proxy is a parallel proxy then this can only set the timeout value of this branch to a value lower than the value in the proxy {@link ProxyExt#getProxy1xxTimeout()} 
	 * 		The effect of expiry of this timeout in case of parallel proxy is just to cancel this branch as if an explicit call to cancel() has been made 
	 * 		if no 1xx response nor final response has been received.
	 * 	</li>
	 * </ul>
	 * @param timeout new search 1xx timeout in seconds
	 * @throws IllegalArgumentException if this value cannot be set by the container. 
	 * Either it is too high, too low, negative or greater than the overall proxy 1xx timeout value in parallel case.
	 * @since 1.3
	 */
	public void setProxyBranch1xxTimeout(int timeout);
	/**
	 * Returns the current value of the search 1xx timeout associated with this ProxyBranch object. 
	 * If this value is not explicitly set using the {@link ProxyBranchExt#setProxyBranch1xxTimeout(int)} then the value is inherited from the Proxy setting.
	 * The current value of the overall proxy 1xx timeout value. This is measured in seconds.
	 * @return the search timeout value in seconds.
	 * @since 1.3
	 */
	public int getProxyBranch1xxTimeout();
}
