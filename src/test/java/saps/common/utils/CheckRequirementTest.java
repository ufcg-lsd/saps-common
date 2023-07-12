/* (C)2020 */
package saps.common.utils;

import org.junit.Test;
import saps.common.exceptions.SapsException;

public class CheckRequirementTest {
  private static class CPU {
    private static class Success {
      private static final String MOCK_1 = "8000m";
      private static final String MOCK_2 = "100m";
    }

    private static class Fail {
      private static final String MOCK_1 = "1";
      private static final String MOCK_2 = "1000";
      private static final String MOCK_3 = "m";
    }
  }

  private static class Memory {
    private static class Success {
      private static final String MOCK_1 = "1K";
      private static final String MOCK_2 = "1M";
      private static final String MOCK_3 = "1G";
      private static final String MOCK_4 = "1T";
      private static final String MOCK_5 = "1P";
      private static final String MOCK_6 = "1E";
    }

    private static class Fail {
      private static final String MOCK_1 = "K";
      private static final String MOCK_2 = "M";
      private static final String MOCK_3 = "G";
      private static final String MOCK_4 = "T";
      private static final String MOCK_5 = "P";
      private static final String MOCK_6 = "E";
      private static final String MOCK_7 = "Kb";
      private static final String MOCK_8 = "Mb";
      private static final String MOCK_9 = "Gb";
      private static final String MOCK_10 = "Tb";
      private static final String MOCK_11 = "Pb";
      private static final String MOCK_12 = "Eb";
      private static final String MOCK_13 = "KB";
      private static final String MOCK_14 = "MB";
      private static final String MOCK_15 = "GB";
      private static final String MOCK_16 = "TB";
      private static final String MOCK_17 = "PB";
      private static final String MOCK_18 = "EB";
      private static final String MOCK_19 = "k";
      private static final String MOCK_20 = "m";
      private static final String MOCK_21 = "g";
      private static final String MOCK_22 = "t";
      private static final String MOCK_23 = "p";
      private static final String MOCK_24 = "e";
    }
  }

  @Test
  public void test1CheckCPURequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        CPU.Success.MOCK_1, ExecutionScriptTag.REGEXP_CPU_REQUIREMENT);
  }

  @Test
  public void test2CheckCPURequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        CPU.Success.MOCK_2, ExecutionScriptTag.REGEXP_CPU_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest1CheckCPURequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        CPU.Fail.MOCK_1, ExecutionScriptTag.REGEXP_CPU_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest2CheckCPURequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        CPU.Fail.MOCK_2, ExecutionScriptTag.REGEXP_CPU_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest3CheckCPURequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        CPU.Fail.MOCK_3, ExecutionScriptTag.REGEXP_CPU_REQUIREMENT);
  }

  @Test
  public void test1CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Success.MOCK_1, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test
  public void test2CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Success.MOCK_2, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test
  public void test3CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Success.MOCK_3, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test
  public void test4CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Success.MOCK_4, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test
  public void test5CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Success.MOCK_5, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test
  public void test6CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Success.MOCK_6, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest1CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_1, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest2CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_2, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest3CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_3, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest4CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_4, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest5CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_5, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest6CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_6, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest7CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_7, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest8CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_8, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest9CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_9, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest10CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_10, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest11CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_11, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest12CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_12, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest13CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_13, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest14CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_14, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest15CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_15, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest16CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_16, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest17CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_17, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest18CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_18, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest19CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_19, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest20CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_20, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest21CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_21, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest22CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_22, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest23CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_23, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }

  @Test(expected = SapsException.class)
  public void failureTest24CheckMemoryRequirement() throws SapsException {
    ExecutionScriptTagUtil.checkRequirement(
        Memory.Fail.MOCK_24, ExecutionScriptTag.REGEXP_MEMORY_REQUIREMENT);
  }
}
