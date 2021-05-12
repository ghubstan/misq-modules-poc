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

package org.misq.grpc;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import misq.proto.grpc.GetVersionReply;
import misq.proto.grpc.GetVersionRequest;
import org.misq.api.CoreApi;

import static misq.proto.grpc.GetVersionGrpc.GetVersionImplBase;

@Slf4j
public class GrpcVersionService extends GetVersionImplBase {

    private final CoreApi coreApi;

    public GrpcVersionService(CoreApi coreApi) {
        this.coreApi = coreApi;
    }

    @Override
    public void getVersion(GetVersionRequest req,
                           StreamObserver<GetVersionReply> responseObserver) {
        try {
            var reply = GetVersionReply.newBuilder()
                    .setVersion(coreApi.getVersion())
                    .build();
            responseObserver.onNext(reply);
            responseObserver.onCompleted();
        } catch (Throwable cause) {
            new GrpcExceptionHandler().handleException(log, cause, responseObserver);
        }
    }
}
