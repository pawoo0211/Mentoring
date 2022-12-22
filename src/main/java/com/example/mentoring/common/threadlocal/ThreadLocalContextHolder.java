package com.example.mentoring.common.threadlocal;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class ThreadLocalContextHolder {

    private static final ThreadLocal<ConcurrentHashMap<String, Object>> THREAD_LOCAL = new ThreadLocal<>();

    public static void setAttributes(ConcurrentHashMap<String, Object> attributes) {
      THREAD_LOCAL.set(attributes);
    }

    public static ConcurrentHashMap<String, Object> getAttributes() {
      return THREAD_LOCAL.get();
    }

    public static Object getAttribute(String key) {
      ConcurrentHashMap<String, Object> localMap = THREAD_LOCAL.get();
      if (localMap == null) {
        return null;
      }

      return THREAD_LOCAL.get().get(key);
    }

    public static <T> T getAttribute(String key, Class<T> classType) {
      ConcurrentHashMap<String, Object> localMap = THREAD_LOCAL.get();
      if (localMap != null) {
        Object value = localMap.get(key);
        if (value != null && value.getClass().isAssignableFrom(classType)) {
          return (T) value;
        }
      }

      log.error("[ThreadContextHolder] threadlocal get value is null");

      StackTraceElement[] elements = Thread.currentThread().getStackTrace();
      for (StackTraceElement e : elements) {
        log.warn("[ThreadContextHolder] stackTrace, {}", e.toString());
      }

      return null;
    }

    public static Object setAttribute(String key, Object value) {
      ConcurrentHashMap<String, Object> localMap = THREAD_LOCAL.get();
      if (localMap == null) {
        localMap = new ConcurrentHashMap<>();
        THREAD_LOCAL.set(localMap);
      }

      return THREAD_LOCAL.get().put(key, value);
    }

    public static void reset() {
      THREAD_LOCAL.remove();
    }
  }

