/*******************************************************************************
 * Copyright (c) 2014, Art Clarke.  All rights reserved.
 *  
 * This file is part of Humble-Video.
 *
 * Humble-Video is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Humble-Video is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Humble-Video.  If not, see <http://www.gnu.org/licenses/>.
 *******************************************************************************/
package io.humble.video;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.junit.Test;

/**
 * @author aclarke
 *
 */
public class DemuxerTest {
  
  @Test
  public void testDemuxing() throws InterruptedException, IOException {
    final URL s = this.getClass().getResource("/testfile_h264_mp4a_tmcd.mov");
    final String f = new File(s.getPath()).getPath();
    
    Demuxer demuxer = Demuxer.make();
    demuxer.open(f, null, false, true, null, null);
    assertEquals(111152819, demuxer.getDuration());
    assertEquals(0, demuxer.getStartTime());
    assertEquals(840154, demuxer.getBitRate());
    assertEquals(3, demuxer.getNumStreams());

  }

}
