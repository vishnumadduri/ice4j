/*
 * ice4j, the OpenSource Java Solution for NAT and Firewall Traversal.
 *
 * Copyright @ 2015 Atlassian Pty Ltd
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ice4j.pseudotcp;

import java.io.*;

/**
 * Notification of tcp events.
 * Is implemented by @link(PseudoTcpSocket) to expose stream functionality.
 * @author Pawel Domas
 */
interface IPseudoTcpNotify
{
    /**
     * Called when tcp enters opened state
     * @param tcp 
     */
    void OnTcpOpen(PseudoTCPBase tcp);

    /**
     * Called when any data is available in read buffer
     * @param tcp 
     */
    void OnTcpReadable(PseudoTCPBase tcp);

    /**
     * Called when there is free space available in the send buffer
     * @param tcp 
     */
    void OnTcpWriteable(PseudoTCPBase tcp);

    /**
     * Called when tcp enters closed state
     * @param tcp
     * @param e null means no error
     */
    void OnTcpClosed(PseudoTCPBase tcp, IOException e);

    /**
     * Called when protocol requests packet transfer through the network.
     * @param tcp
     * @param buffer data
     * @param len data length
     * @return the result, see {@link WriteResult} description for more info
     */    
    WriteResult TcpWritePacket(PseudoTCPBase tcp, byte[] buffer, int len);
}
