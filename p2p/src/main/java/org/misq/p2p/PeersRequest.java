/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package org.misq.p2p;

import lombok.ToString;

@ToString
public class PeersRequest {

    private final NodeAddress senderNodeAddress;

    public PeersRequest(NodeAddress senderNodeAddress) {
        this.senderNodeAddress = senderNodeAddress;
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    // PROTO BUFFER
    ///////////////////////////////////////////////////////////////////////////////////////////

    public org.misq.p2p.proto.PeersRequest toProtoMessage() {
        return org.misq.p2p.proto.PeersRequest.newBuilder()
                .setSenderNodeAddress(senderNodeAddress.toProtoMessage())
                .build();
    }

    public static PeersRequest fromProto(org.misq.p2p.proto.PeersRequest proto) {
        return new PeersRequest(NodeAddress.fromProto(proto.getSenderNodeAddress()));
    }
}
