/*
 * Copyright LWJGL. All rights reserved.
 * License terms: http://lwjgl.org/license.php
 */
package org.lwjgl.opengl.templates

import org.lwjgl.generator.*
import org.lwjgl.opengl.*

val ARB_framebuffer_sRGB = "ARBFramebufferSRGB".nativeClassGL("ARB_framebuffer_sRGB") {
	documentation =
		"""
		Native bindings to the $registryLink extension.

		Conventionally, OpenGL assumes framebuffer color components are stored in a linear color space. In particular, framebuffer blending is a linear
		operation.

		The sRGB color space is based on typical (non-linear) monitor characteristics expected in a dimly lit office. It has been standardized by the
		International Electrotechnical Commission (IEC) as IEC 61966-2-1. The sRGB color space roughly corresponds to 2.2 gamma correction.

		This extension adds a framebuffer capability for sRGB framebuffer update and blending. When blending is disabled but the new sRGB updated mode is
		enabled (assume the framebuffer supports the capability), high-precision linear color component values for red, green, and blue generated by fragment
		coloring are encoded for sRGB prior to being written into the framebuffer. When blending is enabled along with the new sRGB update mode, red, green, and
		blue framebuffer color components are treated as sRGB values that are converted to linear color values, blended with the high-precision color values
		generated by fragment coloring, and then the blend result is encoded for sRGB just prior to being written into the framebuffer.

		The primary motivation for this extension is that it allows OpenGL applications to render into a framebuffer that is scanned to a monitor configured to
		assume framebuffer color values are sRGB encoded. This assumption is roughly true of most PC monitors with default gamma correction. This allows
		applications to achieve faithful color reproduction for OpenGL rendering without adjusting the monitor's gamma correction.

		Requires ${ARB_framebuffer_object.link}. ${GL30.promoted}
		"""

	IntConstant(
		"""
		Accepted by the {@code cap} parameter of Enable, Disable, and IsEnabled, and by the {@code pname} parameter of GetBooleanv, GetIntegerv, GetFloatv, and
		GetDoublev.
		""",

		"FRAMEBUFFER_SRGB" _ 0x8DB9
	)
}

val GLX_ARB_framebuffer_sRGB = "GLXARBFramebufferSRGB".nativeClassGLX("GLX_ARB_framebuffer_sRGB", ARB) {
	documentation =
		"""
		Native bindings to the ${registryLink("ARB", "framebuffer_sRGB")} extension.

		GLX functionality for ${ARB_framebuffer_sRGB.link}.
		"""

	IntConstant(
		"Accepted by the {@code attribList} parameter of GLX#ChooseVisual(), and by the {@code attrib} parameter of GLX#GetConfig().",

		"FRAMEBUFFER_SRGB_CAPABLE_ARB" _ 0x20B2
	)
}

val WGL_ARB_framebuffer_sRGB = "WGLARBFramebufferSRGB".nativeClassWGL("WGL_ARB_framebuffer_sRGB", ARB) {
	documentation =
		"""
		Native bindings to the ${registryLink("ARB", "framebuffer_sRGB")} extension.

		WGL functionality for ${ARB_framebuffer_sRGB.link}.

		Requires ${WGL_EXT_extensions_string.link}, ${WGL_ARB_pixel_format.link} and ${ARB_framebuffer_object.link}.
		"""

	IntConstant(
		"""
		Accepted by the {@code attributes} parameter of WGLARBPixelFormat#GetPixelFormatAttribiARB() and the {@code attribIList} of
		WGLARBPixelFormat#ChoosePixelFormatARB().
		""",

		"FRAMEBUFFER_SRGB_CAPABLE_ARB" _ 0x20A9
	)
}