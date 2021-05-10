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

package org.misq.walletrpc.btc;

import org.misq.walletrpc.WalletRpc;

import java.util.concurrent.CompletableFuture;

public class BitcoinRpcService implements WalletRpc {

    @Override
    public CompletableFuture<Long> requestChainHeadHeight() {
        return null;
    }

    @Override
    public CompletableFuture<String> getBalance() {
        return null;
    }

    @Override
    public CompletableFuture<String> getFreshReceivingAddress(String label) {
        return null;
    }

    @Override
    public CompletableFuture<String> sendToAddress(String address, String amount, String memo) {
        return null;
    }

    @Override
    public void shutDown() {

    }
}
