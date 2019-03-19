
farm.o:     file format elf64-x86-64


Disassembly of section .text:

0000000000000000 <start_farm>:
   0:	55                   	push   %rbp
   1:	48 89 e5             	mov    %rsp,%rbp
   4:	b8 01 00 00 00       	mov    $0x1,%eax
   9:	c9                   	leaveq 
   a:	c3                   	retq   

000000000000000b <addval_484>:
   b:	55                   	push   %rbp
   c:	48 89 e5             	mov    %rsp,%rbp
   f:	89 7d fc             	mov    %edi,-0x4(%rbp)
  12:	8b 45 fc             	mov    -0x4(%rbp),%eax
  15:	2d a8 6d 6f 6f       	sub    $0x6f6f6da8,%eax
  1a:	c9                   	leaveq 
  1b:	c3                   	retq   

000000000000001c <addval_223>:
  1c:	55                   	push   %rbp
  1d:	48 89 e5             	mov    %rsp,%rbp
  20:	89 7d fc             	mov    %edi,-0x4(%rbp)
  23:	8b 45 fc             	mov    -0x4(%rbp),%eax
  26:	05 5b 48 24 58       	add    $0x5824485b,%eax
  2b:	c9                   	leaveq 
  2c:	c3                   	retq   

000000000000002d <setval_285>:
  2d:	55                   	push   %rbp
  2e:	48 89 e5             	mov    %rsp,%rbp
  31:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
  35:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
  39:	c7 00 48 89 c7 90    	movl   $0x90c78948,(%rax)
  3f:	c9                   	leaveq 
  40:	c3                   	retq   

0000000000000041 <getval_301>:
  41:	55                   	push   %rbp
  42:	48 89 e5             	mov    %rsp,%rbp
  45:	b8 58 90 90 c3       	mov    $0xc3909058,%eax
  4a:	c9                   	leaveq 
  4b:	c3                   	retq   

000000000000004c <setval_433>:
  4c:	55                   	push   %rbp
  4d:	48 89 e5             	mov    %rsp,%rbp
  50:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
  54:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
  58:	c7 00 48 89 c7 c2    	movl   $0xc2c78948,(%rax)
  5e:	c9                   	leaveq 
  5f:	c3                   	retq   

0000000000000060 <setval_124>:
  60:	55                   	push   %rbp
  61:	48 89 e5             	mov    %rsp,%rbp
  64:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
  68:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
  6c:	c7 00 48 99 c7 c3    	movl   $0xc3c79948,(%rax)
  72:	c9                   	leaveq 
  73:	c3                   	retq   

0000000000000074 <setval_340>:
  74:	55                   	push   %rbp
  75:	48 89 e5             	mov    %rsp,%rbp
  78:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
  7c:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
  80:	c7 00 1c 48 89 c7    	movl   $0xc789481c,(%rax)
  86:	c9                   	leaveq 
  87:	c3                   	retq   

0000000000000088 <addval_365>:
  88:	55                   	push   %rbp
  89:	48 89 e5             	mov    %rsp,%rbp
  8c:	89 7d fc             	mov    %edi,-0x4(%rbp)
  8f:	8b 45 fc             	mov    -0x4(%rbp),%eax
  92:	2d b0 6f 6f 6f       	sub    $0x6f6f6fb0,%eax
  97:	c9                   	leaveq 
  98:	c3                   	retq   

0000000000000099 <mid_farm>:
  99:	55                   	push   %rbp
  9a:	48 89 e5             	mov    %rsp,%rbp
  9d:	b8 01 00 00 00       	mov    $0x1,%eax
  a2:	c9                   	leaveq 
  a3:	c3                   	retq   

00000000000000a4 <add_xy>:
  a4:	55                   	push   %rbp
  a5:	48 89 e5             	mov    %rsp,%rbp
  a8:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
  ac:	48 89 75 f0          	mov    %rsi,-0x10(%rbp)
  b0:	48 8b 45 f0          	mov    -0x10(%rbp),%rax
  b4:	48 8b 55 f8          	mov    -0x8(%rbp),%rdx
  b8:	48 8d 04 02          	lea    (%rdx,%rax,1),%rax
  bc:	c9                   	leaveq 
  bd:	c3                   	retq   

00000000000000be <getval_404>:
  be:	55                   	push   %rbp
  bf:	48 89 e5             	mov    %rsp,%rbp
  c2:	b8 89 ca 78 c9       	mov    $0xc978ca89,%eax
  c7:	c9                   	leaveq 
  c8:	c3                   	retq   

00000000000000c9 <getval_314>:
  c9:	55                   	push   %rbp
  ca:	48 89 e5             	mov    %rsp,%rbp
  cd:	b8 27 40 89 ca       	mov    $0xca894027,%eax
  d2:	c9                   	leaveq 
  d3:	c3                   	retq   

00000000000000d4 <addval_306>:
  d4:	55                   	push   %rbp
  d5:	48 89 e5             	mov    %rsp,%rbp
  d8:	89 7d fc             	mov    %edi,-0x4(%rbp)
  db:	8b 45 fc             	mov    -0x4(%rbp),%eax
  de:	2d f7 3e f7 36       	sub    $0x36f73ef7,%eax
  e3:	c9                   	leaveq 
  e4:	c3                   	retq   

00000000000000e5 <addval_432>:
  e5:	55                   	push   %rbp
  e6:	48 89 e5             	mov    %rsp,%rbp
  e9:	89 7d fc             	mov    %edi,-0x4(%rbp)
  ec:	8b 45 fc             	mov    -0x4(%rbp),%eax
  ef:	2d b8 76 1f 6f       	sub    $0x6f1f76b8,%eax
  f4:	c9                   	leaveq 
  f5:	c3                   	retq   

00000000000000f6 <getval_187>:
  f6:	55                   	push   %rbp
  f7:	48 89 e5             	mov    %rsp,%rbp
  fa:	b8 81 c1 08 c9       	mov    $0xc908c181,%eax
  ff:	c9                   	leaveq 
 100:	c3                   	retq   

0000000000000101 <addval_337>:
 101:	55                   	push   %rbp
 102:	48 89 e5             	mov    %rsp,%rbp
 105:	89 7d fc             	mov    %edi,-0x4(%rbp)
 108:	8b 45 fc             	mov    -0x4(%rbp),%eax
 10b:	2d 77 29 3b 3f       	sub    $0x3f3b2977,%eax
 110:	c9                   	leaveq 
 111:	c3                   	retq   

0000000000000112 <setval_199>:
 112:	55                   	push   %rbp
 113:	48 89 e5             	mov    %rsp,%rbp
 116:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 11a:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 11e:	c7 00 48 89 e0 c7    	movl   $0xc7e08948,(%rax)
 124:	c9                   	leaveq 
 125:	c3                   	retq   

0000000000000126 <setval_244>:
 126:	55                   	push   %rbp
 127:	48 89 e5             	mov    %rsp,%rbp
 12a:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 12e:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 132:	c7 00 c9 ca 08 c9    	movl   $0xc908cac9,(%rax)
 138:	c9                   	leaveq 
 139:	c3                   	retq   

000000000000013a <addval_466>:
 13a:	55                   	push   %rbp
 13b:	48 89 e5             	mov    %rsp,%rbp
 13e:	89 7d fc             	mov    %edi,-0x4(%rbp)
 141:	8b 45 fc             	mov    -0x4(%rbp),%eax
 144:	2d 77 29 3c 5e       	sub    $0x5e3c2977,%eax
 149:	c9                   	leaveq 
 14a:	c3                   	retq   

000000000000014b <addval_166>:
 14b:	55                   	push   %rbp
 14c:	48 89 e5             	mov    %rsp,%rbp
 14f:	89 7d fc             	mov    %edi,-0x4(%rbp)
 152:	8b 45 fc             	mov    -0x4(%rbp),%eax
 155:	2d b8 76 1f 6f       	sub    $0x6f1f76b8,%eax
 15a:	c9                   	leaveq 
 15b:	c3                   	retq   

000000000000015c <setval_207>:
 15c:	55                   	push   %rbp
 15d:	48 89 e5             	mov    %rsp,%rbp
 160:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 164:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 168:	c7 00 e4 48 88 e0    	movl   $0xe08848e4,(%rax)
 16e:	c9                   	leaveq 
 16f:	c3                   	retq   

0000000000000170 <setval_421>:
 170:	55                   	push   %rbp
 171:	48 89 e5             	mov    %rsp,%rbp
 174:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 178:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 17c:	c7 00 4a 89 e0 c3    	movl   $0xc3e0894a,(%rax)
 182:	c9                   	leaveq 
 183:	c3                   	retq   

0000000000000184 <setval_177>:
 184:	55                   	push   %rbp
 185:	48 89 e5             	mov    %rsp,%rbp
 188:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 18c:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 190:	c7 00 89 d6 78 c0    	movl   $0xc078d689,(%rax)
 196:	c9                   	leaveq 
 197:	c3                   	retq   

0000000000000198 <getval_277>:
 198:	55                   	push   %rbp
 199:	48 89 e5             	mov    %rsp,%rbp
 19c:	b8 c9 c1 84 d2       	mov    $0xd284c1c9,%eax
 1a1:	c9                   	leaveq 
 1a2:	c3                   	retq   

00000000000001a3 <addval_438>:
 1a3:	55                   	push   %rbp
 1a4:	48 89 e5             	mov    %rsp,%rbp
 1a7:	89 7d fc             	mov    %edi,-0x4(%rbp)
 1aa:	8b 45 fc             	mov    -0x4(%rbp),%eax
 1ad:	2d b8 74 1f 6f       	sub    $0x6f1f74b8,%eax
 1b2:	c9                   	leaveq 
 1b3:	c3                   	retq   

00000000000001b4 <setval_273>:
 1b4:	55                   	push   %rbp
 1b5:	48 89 e5             	mov    %rsp,%rbp
 1b8:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 1bc:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 1c0:	c7 00 89 ca c4 d2    	movl   $0xd2c4ca89,(%rax)
 1c6:	c9                   	leaveq 
 1c7:	c3                   	retq   

00000000000001c8 <getval_143>:
 1c8:	55                   	push   %rbp
 1c9:	48 89 e5             	mov    %rsp,%rbp
 1cc:	b8 89 ca 20 db       	mov    $0xdb20ca89,%eax
 1d1:	c9                   	leaveq 
 1d2:	c3                   	retq   

00000000000001d3 <setval_366>:
 1d3:	55                   	push   %rbp
 1d4:	48 89 e5             	mov    %rsp,%rbp
 1d7:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 1db:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 1df:	c7 00 89 c1 00 db    	movl   $0xdb00c189,(%rax)
 1e5:	c9                   	leaveq 
 1e6:	c3                   	retq   

00000000000001e7 <setval_392>:
 1e7:	55                   	push   %rbp
 1e8:	48 89 e5             	mov    %rsp,%rbp
 1eb:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 1ef:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 1f3:	c7 00 89 ca 94 db    	movl   $0xdb94ca89,(%rax)
 1f9:	c9                   	leaveq 
 1fa:	c3                   	retq   

00000000000001fb <addval_492>:
 1fb:	55                   	push   %rbp
 1fc:	48 89 e5             	mov    %rsp,%rbp
 1ff:	89 7d fc             	mov    %edi,-0x4(%rbp)
 202:	8b 45 fc             	mov    -0x4(%rbp),%eax
 205:	2d 77 29 87 36       	sub    $0x36872977,%eax
 20a:	c9                   	leaveq 
 20b:	c3                   	retq   

000000000000020c <addval_116>:
 20c:	55                   	push   %rbp
 20d:	48 89 e5             	mov    %rsp,%rbp
 210:	89 7d fc             	mov    %edi,-0x4(%rbp)
 213:	8b 45 fc             	mov    -0x4(%rbp),%eax
 216:	2d 77 29 6d 6f       	sub    $0x6f6d2977,%eax
 21b:	c9                   	leaveq 
 21c:	c3                   	retq   

000000000000021d <getval_215>:
 21d:	55                   	push   %rbp
 21e:	48 89 e5             	mov    %rsp,%rbp
 221:	b8 a9 c1 84 c9       	mov    $0xc984c1a9,%eax
 226:	c9                   	leaveq 
 227:	c3                   	retq   

0000000000000228 <addval_485>:
 228:	55                   	push   %rbp
 229:	48 89 e5             	mov    %rsp,%rbp
 22c:	89 7d fc             	mov    %edi,-0x4(%rbp)
 22f:	8b 45 fc             	mov    -0x4(%rbp),%eax
 232:	2d b4 76 1f 6f       	sub    $0x6f1f76b4,%eax
 237:	c9                   	leaveq 
 238:	c3                   	retq   

0000000000000239 <getval_410>:
 239:	55                   	push   %rbp
 23a:	48 89 e5             	mov    %rsp,%rbp
 23d:	b8 b8 68 89 e0       	mov    $0xe08968b8,%eax
 242:	c9                   	leaveq 
 243:	c3                   	retq   

0000000000000244 <getval_156>:
 244:	55                   	push   %rbp
 245:	48 89 e5             	mov    %rsp,%rbp
 248:	b8 89 d6 c3 7e       	mov    $0x7ec3d689,%eax
 24d:	c9                   	leaveq 
 24e:	c3                   	retq   

000000000000024f <setval_427>:
 24f:	55                   	push   %rbp
 250:	48 89 e5             	mov    %rsp,%rbp
 253:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 257:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 25b:	c7 00 89 c1 c4 db    	movl   $0xdbc4c189,(%rax)
 261:	c9                   	leaveq 
 262:	c3                   	retq   

0000000000000263 <addval_409>:
 263:	55                   	push   %rbp
 264:	48 89 e5             	mov    %rsp,%rbp
 267:	89 7d fc             	mov    %edi,-0x4(%rbp)
 26a:	8b 45 fc             	mov    -0x4(%rbp),%eax
 26d:	2d 75 35 7b 36       	sub    $0x367b3575,%eax
 272:	c9                   	leaveq 
 273:	c3                   	retq   

0000000000000274 <setval_350>:
 274:	55                   	push   %rbp
 275:	48 89 e5             	mov    %rsp,%rbp
 278:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 27c:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 280:	c7 00 89 d6 a4 c9    	movl   $0xc9a4d689,(%rax)
 286:	c9                   	leaveq 
 287:	c3                   	retq   

0000000000000288 <setval_498>:
 288:	55                   	push   %rbp
 289:	48 89 e5             	mov    %rsp,%rbp
 28c:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 290:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 294:	c7 00 99 ca 38 c9    	movl   $0xc938ca99,(%rax)
 29a:	c9                   	leaveq 
 29b:	c3                   	retq   

000000000000029c <setval_351>:
 29c:	55                   	push   %rbp
 29d:	48 89 e5             	mov    %rsp,%rbp
 2a0:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 2a4:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 2a8:	c7 00 b4 89 8d d6    	movl   $0xd68d89b4,(%rax)
 2ae:	c9                   	leaveq 
 2af:	c3                   	retq   

00000000000002b0 <getval_435>:
 2b0:	55                   	push   %rbp
 2b1:	48 89 e5             	mov    %rsp,%rbp
 2b4:	b8 a4 18 89 c1       	mov    $0xc18918a4,%eax
 2b9:	c9                   	leaveq 
 2ba:	c3                   	retq   

00000000000002bb <setval_162>:
 2bb:	55                   	push   %rbp
 2bc:	48 89 e5             	mov    %rsp,%rbp
 2bf:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 2c3:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 2c7:	c7 00 89 c1 08 d2    	movl   $0xd208c189,(%rax)
 2cd:	c9                   	leaveq 
 2ce:	c3                   	retq   

00000000000002cf <end_farm>:
 2cf:	55                   	push   %rbp
 2d0:	48 89 e5             	mov    %rsp,%rbp
 2d3:	b8 01 00 00 00       	mov    $0x1,%eax
 2d8:	c9                   	leaveq 
 2d9:	c3                   	retq   
