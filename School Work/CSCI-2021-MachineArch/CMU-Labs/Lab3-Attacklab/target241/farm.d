
farm.o:     file format elf64-x86-64


Disassembly of section .text:

0000000000000000 <start_farm>:
   0:	55                   	push   %rbp
   1:	48 89 e5             	mov    %rsp,%rbp
   4:	b8 01 00 00 00       	mov    $0x1,%eax
   9:	c9                   	leaveq 
   a:	c3                   	retq   

000000000000000b <setval_242>:
   b:	55                   	push   %rbp
   c:	48 89 e5             	mov    %rsp,%rbp
   f:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
  13:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
  17:	c7 00 58 90 90 c3    	movl   $0xc3909058,(%rax)
  1d:	c9                   	leaveq 
  1e:	c3                   	retq   

000000000000001f <addval_429>:
  1f:	55                   	push   %rbp
  20:	48 89 e5             	mov    %rsp,%rbp
  23:	89 7d fc             	mov    %edi,-0x4(%rbp)
  26:	8b 45 fc             	mov    -0x4(%rbp),%eax
  29:	2d ec cd a7 3c       	sub    $0x3ca7cdec,%eax
  2e:	c9                   	leaveq 
  2f:	c3                   	retq   

0000000000000030 <addval_114>:
  30:	55                   	push   %rbp
  31:	48 89 e5             	mov    %rsp,%rbp
  34:	89 7d fc             	mov    %edi,-0x4(%rbp)
  37:	8b 45 fc             	mov    -0x4(%rbp),%eax
  3a:	2d 51 37 76 38       	sub    $0x38763751,%eax
  3f:	c9                   	leaveq 
  40:	c3                   	retq   

0000000000000041 <setval_177>:
  41:	55                   	push   %rbp
  42:	48 89 e5             	mov    %rsp,%rbp
  45:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
  49:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
  4d:	c7 00 40 89 c7 c3    	movl   $0xc3c78940,(%rax)
  53:	c9                   	leaveq 
  54:	c3                   	retq   

0000000000000055 <getval_431>:
  55:	55                   	push   %rbp
  56:	48 89 e5             	mov    %rsp,%rbp
  59:	b8 48 89 c7 c3       	mov    $0xc3c78948,%eax
  5e:	c9                   	leaveq 
  5f:	c3                   	retq   

0000000000000060 <addval_174>:
  60:	55                   	push   %rbp
  61:	48 89 e5             	mov    %rsp,%rbp
  64:	89 7d fc             	mov    %edi,-0x4(%rbp)
  67:	8b 45 fc             	mov    -0x4(%rbp),%eax
  6a:	2d b8 76 38 6f       	sub    $0x6f3876b8,%eax
  6f:	c9                   	leaveq 
  70:	c3                   	retq   

0000000000000071 <setval_206>:
  71:	55                   	push   %rbp
  72:	48 89 e5             	mov    %rsp,%rbp
  75:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
  79:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
  7d:	c7 00 58 90 90 c1    	movl   $0xc1909058,(%rax)
  83:	c9                   	leaveq 
  84:	c3                   	retq   

0000000000000085 <addval_306>:
  85:	55                   	push   %rbp
  86:	48 89 e5             	mov    %rsp,%rbp
  89:	89 7d fc             	mov    %edi,-0x4(%rbp)
  8c:	8b 45 fc             	mov    -0x4(%rbp),%eax
  8f:	2d a8 38 04 31       	sub    $0x310438a8,%eax
  94:	c9                   	leaveq 
  95:	c3                   	retq   

0000000000000096 <mid_farm>:
  96:	55                   	push   %rbp
  97:	48 89 e5             	mov    %rsp,%rbp
  9a:	b8 01 00 00 00       	mov    $0x1,%eax
  9f:	c9                   	leaveq 
  a0:	c3                   	retq   

00000000000000a1 <add_xy>:
  a1:	55                   	push   %rbp
  a2:	48 89 e5             	mov    %rsp,%rbp
  a5:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
  a9:	48 89 75 f0          	mov    %rsi,-0x10(%rbp)
  ad:	48 8b 45 f0          	mov    -0x10(%rbp),%rax
  b1:	48 8b 55 f8          	mov    -0x8(%rbp),%rdx
  b5:	48 8d 04 02          	lea    (%rdx,%rax,1),%rax
  b9:	c9                   	leaveq 
  ba:	c3                   	retq   

00000000000000bb <getval_315>:
  bb:	55                   	push   %rbp
  bc:	48 89 e5             	mov    %rsp,%rbp
  bf:	b8 89 c1 90 c3       	mov    $0xc390c189,%eax
  c4:	c9                   	leaveq 
  c5:	c3                   	retq   

00000000000000c6 <setval_488>:
  c6:	55                   	push   %rbp
  c7:	48 89 e5             	mov    %rsp,%rbp
  ca:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
  ce:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
  d2:	c7 00 89 ca c3 53    	movl   $0x53c3ca89,(%rax)
  d8:	c9                   	leaveq 
  d9:	c3                   	retq   

00000000000000da <setval_267>:
  da:	55                   	push   %rbp
  db:	48 89 e5             	mov    %rsp,%rbp
  de:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
  e2:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
  e6:	c7 00 99 ca 20 d2    	movl   $0xd220ca99,(%rax)
  ec:	c9                   	leaveq 
  ed:	c3                   	retq   

00000000000000ee <addval_418>:
  ee:	55                   	push   %rbp
  ef:	48 89 e5             	mov    %rsp,%rbp
  f2:	89 7d fc             	mov    %edi,-0x4(%rbp)
  f5:	8b 45 fc             	mov    -0x4(%rbp),%eax
  f8:	2d 38 76 1f 6f       	sub    $0x6f1f7638,%eax
  fd:	c9                   	leaveq 
  fe:	c3                   	retq   

00000000000000ff <setval_408>:
  ff:	55                   	push   %rbp
 100:	48 89 e5             	mov    %rsp,%rbp
 103:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 107:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 10b:	c7 00 48 09 e0 90    	movl   $0x90e00948,(%rax)
 111:	c9                   	leaveq 
 112:	c3                   	retq   

0000000000000113 <setval_170>:
 113:	55                   	push   %rbp
 114:	48 89 e5             	mov    %rsp,%rbp
 117:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 11b:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 11f:	c7 00 cd 48 89 e0    	movl   $0xe08948cd,(%rax)
 125:	c9                   	leaveq 
 126:	c3                   	retq   

0000000000000127 <getval_344>:
 127:	55                   	push   %rbp
 128:	48 89 e5             	mov    %rsp,%rbp
 12b:	b8 8d d6 90 c3       	mov    $0xc390d68d,%eax
 130:	c9                   	leaveq 
 131:	c3                   	retq   

0000000000000132 <setval_181>:
 132:	55                   	push   %rbp
 133:	48 89 e5             	mov    %rsp,%rbp
 136:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 13a:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 13e:	c7 00 48 89 e0 91    	movl   $0x91e08948,(%rax)
 144:	c9                   	leaveq 
 145:	c3                   	retq   

0000000000000146 <getval_375>:
 146:	55                   	push   %rbp
 147:	48 89 e5             	mov    %rsp,%rbp
 14a:	b8 d0 99 c1 c3       	mov    $0xc3c199d0,%eax
 14f:	c9                   	leaveq 
 150:	c3                   	retq   

0000000000000151 <getval_198>:
 151:	55                   	push   %rbp
 152:	48 89 e5             	mov    %rsp,%rbp
 155:	b8 89 c1 c2 f3       	mov    $0xf3c2c189,%eax
 15a:	c9                   	leaveq 
 15b:	c3                   	retq   

000000000000015c <setval_271>:
 15c:	55                   	push   %rbp
 15d:	48 89 e5             	mov    %rsp,%rbp
 160:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 164:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 168:	c7 00 ab 48 89 e0    	movl   $0xe08948ab,(%rax)
 16e:	c9                   	leaveq 
 16f:	c3                   	retq   

0000000000000170 <addval_143>:
 170:	55                   	push   %rbp
 171:	48 89 e5             	mov    %rsp,%rbp
 174:	89 7d fc             	mov    %edi,-0x4(%rbp)
 177:	8b 45 fc             	mov    -0x4(%rbp),%eax
 17a:	2d 57 3e df 24       	sub    $0x24df3e57,%eax
 17f:	c9                   	leaveq 
 180:	c3                   	retq   

0000000000000181 <getval_262>:
 181:	55                   	push   %rbp
 182:	48 89 e5             	mov    %rsp,%rbp
 185:	b8 8b d6 20 d2       	mov    $0xd220d68b,%eax
 18a:	c9                   	leaveq 
 18b:	c3                   	retq   

000000000000018c <setval_473>:
 18c:	55                   	push   %rbp
 18d:	48 89 e5             	mov    %rsp,%rbp
 190:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 194:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 198:	c7 00 89 ca 92 90    	movl   $0x9092ca89,(%rax)
 19e:	c9                   	leaveq 
 19f:	c3                   	retq   

00000000000001a0 <setval_168>:
 1a0:	55                   	push   %rbp
 1a1:	48 89 e5             	mov    %rsp,%rbp
 1a4:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 1a8:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 1ac:	c7 00 89 ca 00 c0    	movl   $0xc000ca89,(%rax)
 1b2:	c9                   	leaveq 
 1b3:	c3                   	retq   

00000000000001b4 <setval_159>:
 1b4:	55                   	push   %rbp
 1b5:	48 89 e5             	mov    %rsp,%rbp
 1b8:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 1bc:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 1c0:	c7 00 99 c1 08 c0    	movl   $0xc008c199,(%rax)
 1c6:	c9                   	leaveq 
 1c7:	c3                   	retq   

00000000000001c8 <setval_436>:
 1c8:	55                   	push   %rbp
 1c9:	48 89 e5             	mov    %rsp,%rbp
 1cc:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 1d0:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 1d4:	c7 00 c9 d6 20 d2    	movl   $0xd220d6c9,(%rax)
 1da:	c9                   	leaveq 
 1db:	c3                   	retq   

00000000000001dc <addval_133>:
 1dc:	55                   	push   %rbp
 1dd:	48 89 e5             	mov    %rsp,%rbp
 1e0:	89 7d fc             	mov    %edi,-0x4(%rbp)
 1e3:	8b 45 fc             	mov    -0x4(%rbp),%eax
 1e6:	2d 65 76 35 3d       	sub    $0x3d357665,%eax
 1eb:	c9                   	leaveq 
 1ec:	c3                   	retq   

00000000000001ed <addval_447>:
 1ed:	55                   	push   %rbp
 1ee:	48 89 e5             	mov    %rsp,%rbp
 1f1:	89 7d fc             	mov    %edi,-0x4(%rbp)
 1f4:	8b 45 fc             	mov    -0x4(%rbp),%eax
 1f7:	2d c0 76 1f 3c       	sub    $0x3c1f76c0,%eax
 1fc:	c9                   	leaveq 
 1fd:	c3                   	retq   

00000000000001fe <addval_370>:
 1fe:	55                   	push   %rbp
 1ff:	48 89 e5             	mov    %rsp,%rbp
 202:	89 7d fc             	mov    %edi,-0x4(%rbp)
 205:	8b 45 fc             	mov    -0x4(%rbp),%eax
 208:	2d 77 29 3c 06       	sub    $0x63c2977,%eax
 20d:	c9                   	leaveq 
 20e:	c3                   	retq   

000000000000020f <setval_202>:
 20f:	55                   	push   %rbp
 210:	48 89 e5             	mov    %rsp,%rbp
 213:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 217:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 21b:	c7 00 c9 d6 38 c0    	movl   $0xc038d6c9,(%rax)
 221:	c9                   	leaveq 
 222:	c3                   	retq   

0000000000000223 <setval_497>:
 223:	55                   	push   %rbp
 224:	48 89 e5             	mov    %rsp,%rbp
 227:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 22b:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 22f:	c7 00 89 ca 90 c3    	movl   $0xc390ca89,(%rax)
 235:	c9                   	leaveq 
 236:	c3                   	retq   

0000000000000237 <getval_394>:
 237:	55                   	push   %rbp
 238:	48 89 e5             	mov    %rsp,%rbp
 23b:	b8 89 d6 28 db       	mov    $0xdb28d689,%eax
 240:	c9                   	leaveq 
 241:	c3                   	retq   

0000000000000242 <getval_146>:
 242:	55                   	push   %rbp
 243:	48 89 e5             	mov    %rsp,%rbp
 246:	b8 b0 89 ca c7       	mov    $0xc7ca89b0,%eax
 24b:	c9                   	leaveq 
 24c:	c3                   	retq   

000000000000024d <getval_111>:
 24d:	55                   	push   %rbp
 24e:	48 89 e5             	mov    %rsp,%rbp
 251:	b8 81 ca 84 db       	mov    $0xdb84ca81,%eax
 256:	c9                   	leaveq 
 257:	c3                   	retq   

0000000000000258 <getval_396>:
 258:	55                   	push   %rbp
 259:	48 89 e5             	mov    %rsp,%rbp
 25c:	b8 89 d6 28 c9       	mov    $0xc928d689,%eax
 261:	c9                   	leaveq 
 262:	c3                   	retq   

0000000000000263 <setval_124>:
 263:	55                   	push   %rbp
 264:	48 89 e5             	mov    %rsp,%rbp
 267:	48 89 7d f8          	mov    %rdi,-0x8(%rbp)
 26b:	48 8b 45 f8          	mov    -0x8(%rbp),%rax
 26f:	c7 00 f8 81 c1 c3    	movl   $0xc3c181f8,(%rax)
 275:	c9                   	leaveq 
 276:	c3                   	retq   

0000000000000277 <addval_171>:
 277:	55                   	push   %rbp
 278:	48 89 e5             	mov    %rsp,%rbp
 27b:	89 7d fc             	mov    %edi,-0x4(%rbp)
 27e:	8b 45 fc             	mov    -0x4(%rbp),%eax
 281:	2d 77 3e 6f 3c       	sub    $0x3c6f3e77,%eax
 286:	c9                   	leaveq 
 287:	c3                   	retq   

0000000000000288 <getval_374>:
 288:	55                   	push   %rbp
 289:	48 89 e5             	mov    %rsp,%rbp
 28c:	b8 d6 89 d6 c3       	mov    $0xc3d689d6,%eax
 291:	c9                   	leaveq 
 292:	c3                   	retq   

0000000000000293 <getval_288>:
 293:	55                   	push   %rbp
 294:	48 89 e5             	mov    %rsp,%rbp
 297:	b8 48 89 e0 91       	mov    $0x91e08948,%eax
 29c:	c9                   	leaveq 
 29d:	c3                   	retq   

000000000000029e <getval_355>:
 29e:	55                   	push   %rbp
 29f:	48 89 e5             	mov    %rsp,%rbp
 2a2:	b8 48 89 e0 c1       	mov    $0xc1e08948,%eax
 2a7:	c9                   	leaveq 
 2a8:	c3                   	retq   

00000000000002a9 <addval_182>:
 2a9:	55                   	push   %rbp
 2aa:	48 89 e5             	mov    %rsp,%rbp
 2ad:	89 7d fc             	mov    %edi,-0x4(%rbp)
 2b0:	8b 45 fc             	mov    -0x4(%rbp),%eax
 2b3:	2d f7 3e f7 2d       	sub    $0x2df73ef7,%eax
 2b8:	c9                   	leaveq 
 2b9:	c3                   	retq   

00000000000002ba <end_farm>:
 2ba:	55                   	push   %rbp
 2bb:	48 89 e5             	mov    %rsp,%rbp
 2be:	b8 01 00 00 00       	mov    $0x1,%eax
 2c3:	c9                   	leaveq 
 2c4:	c3                   	retq   
