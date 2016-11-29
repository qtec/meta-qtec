# Copyright (C) 2014 Khem Raj <raj.khem@gmail.com>
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "LLVM based C/C++ compiler"
HOMEPAGE = "http://clang.llvm.org/"
LICENSE = "NCSA"
SECTION = "devel"

require clang.inc

PV .= "+git${SRCPV}"

LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=${LLVMMD5SUM}; \
                    file://tools/clang/LICENSE.TXT;md5=${CLANGMD5SUM}; \
                   "
SRC_URI = "${LLVM_GIT}/llvm.git;protocol=${LLVM_GIT_PROTOCOL};branch=${BRANCH};name=llvm \
           ${LLVM_GIT}/clang.git;protocol=${LLVM_GIT_PROTOCOL};branch=${BRANCH};destsuffix=git/tools/clang;name=clang \
           file://0001-llvm-Remove-CMAKE_CROSSCOMPILING-so-it-can-cross-com.patch \
           file://0002-llvm-Do-not-assume-linux-glibc.patch \
           file://0003-llvm-TargetLibraryInfo-Undefine-libc-functions-if-th.patch \
           file://0004-llvm-Fix-inconsistent-uses-of-.cfi_sections.patch \
           file://0005-llvm-Fix-build-on-mips-ppc-disable-EH-table-support.patch \
           \
           file://0001-clang-driver-Use-lib-for-ldso-on-OE.patch;patchdir=tools/clang \
           file://0002-clang-Driver-tools.cpp-Add-lssp-and-lssp_nonshared-o.patch;patchdir=tools/clang \
           file://0003-clang-musl-ppc-does-not-support-128-bit-long-double.patch;patchdir=tools/clang \
           file://0004-clang-Check-for-float-ABI-on-arm.patch;patchdir=tools/clang \
          "

SRCREV_FORMAT = "llvm_clang"

INHIBIT_DEFAULT_DEPS = "1"

S = "${WORKDIR}/git"

inherit cmake native

OECMAKE_FIND_ROOT_PATH_MODE_PROGRAM = "BOTH"

EXTRA_OECMAKE="-DLLVM_ENABLE_RTTI=True \
               -DLLVM_ENABLE_FFI=False \
               -DCMAKE_SYSTEM_NAME=Linux \
               -DCMAKE_BUILD_TYPE=Release \
	       -DLLVM_BUILD_EXTERNAL_COMPILER_RT=True \
               -DLLVM_TARGETS_TO_BUILD='AArch64;ARM;Mips;PowerPC;X86' \
	      "

EXTRA_OEMAKE += "REQUIRES_RTTI=1 VERBOSE=1"

DEPENDS = "zlib libffi libxml2 binutils"

do_compile_prepend() {
	oe_runmake LLVM-tablegen-host
	oe_runmake CLANG-tablegen-host
}

do_install_append () {
	install -Dm 0755 ${B}/NATIVE/bin/clang-tblgen ${D}${bindir}/clang-tblgen
	for f in `find ${D}${bindir} -executable -type f -not -type l`; do
		test -n "`file $f|grep -i ELF`" && ${STRIP} $f
		echo "stripped $f"
	done
}

FILES_${PN} += "\
  ${libdir}/BugpointPasses.so \
  ${libdir}/LLVMHello.so \
  ${datadir}/scan-* \
"

FILES_${PN}-dev += "\
  ${datadir}/llvm/cmake \
  ${libdir}/cmake \
"

INSANE_SKIP_${PN} += "already-stripped"
INSANE_SKIP_${PN}-dev += "dev-elf"
