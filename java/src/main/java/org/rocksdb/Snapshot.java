// Copyright (c) 2011-present, Facebook, Inc.  All rights reserved.
// This source code is licensed under the BSD-style license found in the
// LICENSE file in the root directory of this source tree. An additional grant
// of patent rights can be found in the PATENTS file in the same directory.

package org.rocksdb;

/**
 * Snapshot of database
 */
public class Snapshot extends RocksObject {
  Snapshot(final long nativeHandle) {
    super(nativeHandle);

    // The pointer to the snapshot is always released
    // by the database instance.
    disOwnNativeHandle();
  }

  /**
   * Return the associated sequence number;
   *
   * @return the associated sequence number of
   *     this snapshot.
   */
  public long getSequenceNumber() {
    return getSequenceNumber(nativeHandle_);
  }


  @Override
  protected final void disposeInternal(final long handle) {
    /**
     * Nothing to release, we never own the pointer for a
     * Snapshot. The pointer
     * to the snapshot is released by the database
     * instance.
     */
  }

  private native long getSequenceNumber(long handle);
}
