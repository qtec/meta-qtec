DESCRIPTION = "The Low Level Virtual Machine"
HOMEPAGE = "http://llvm.org"

#Important, this version cannot be installed with other llvm versions!
#it is just a workaround until llvm is part of meta-oe
#we do not want to end up mantaining this cross madness

LICENSE = "NCSA"
DEPENDS = "zlib libffi libxml2 binutils"
PROVIDES += "llvm"

LIC_FILES_CHKSUM = "file://LICENSE.TXT;md5=${LLVMMD5SUM}; \
                    file://tools/clang/LICENSE.TXT;md5=${CLANGMD5SUM};"

require ../clang/clang.inc

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
	   \
           file://CrossCompile.patch \
          "
EXTRA_OECMAKE="-DLLVM_ENABLE_RTTI=True \
               -DLLVM_ENABLE_FFI=False \
               -DCMAKE_SYSTEM_NAME=Linux \
               -DCMAKE_BUILD_TYPE=Release \
	       -DLLVM_BUILD_EXTERNAL_COMPILER_RT=True \
               -DLLVM_ENABLE_PIC=False \
	       -DCROSS_TOOLCHAIN_FLAGS_NATIVE=-DCMAKE_TOOLCHAIN_FILE=${S}/NATIVE.cmake \
               -DLLVM_TARGETS_TO_BUILD="X86;AMDGPU" \
               -DLLVM_TARGET_ARCH=X86 \
	       -DLLVM_BUILD_LLVM_DYLIB=True \
	      "

OECMAKE_C_FLAGS_append = " -fPIC"
OECMAKE_CXX_FLAGS_append = " -fPIC"

#Do not use BUILD_SHARED_LIBS!
#http://wiki.linuxfromscratch.org/blfs/ticket/8291#comment:5

do_configure_prepend(){
	echo 'set(CMAKE_C_COMPILER cc)' > ${S}/NATIVE.cmake
	echo 'set(CMAKE_CXX_COMPILER c++)' >> ${S}/NATIVE.cmake
}

#This is a hack to fix an out of order build error
do_compile_prepend(){
	cd NATIVE/lib/Support/
	oe_runmake
	cd ../../..
}

#Native llvm-config is not built unless is explicitly requested
do_compile_append(){
	cd NATIVE
	oe_runmake llvm-config
	cd ..
}

S = "${WORKDIR}/git"

inherit cmake pythonnative

#This is a hack, it should be installded in bindir_crosscripts, but I do not want to patch llvm-config.cc
#The same file is used for host and target
SYSROOT_PREPROCESS_FUNCS += "llvm_sysroot_preprocess"
llvm_sysroot_preprocess() {
    install -d ${SYSROOT_DESTDIR}${bindir_crossscripts}
    install -m 0755 NATIVE/bin/llvm-config ${SYSROOT_DESTDIR}${bindir_crossscripts}/../llvm-config${PV}
}

FILES_${PN}-dev = "${libdir}/cmake/ ${includedir}/ ${libdir}/libLLVM-3.9.0.so ${libdir}/libLLVM.so"
FILES_${PN} += "${libdir}/clang/ ${libdir}/BugpointPasses.so ${libdir}/LLVMHello.so /usr/share/ ${libdir}/libLLVM-3.9.so"
