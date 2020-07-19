学习笔记
// 1.使用add first,add last改写Deque代码
Deque<String> deque = new LinkedList<String>();
deque.addFirst("a");
deque.addLast("b");
deque.addFirst("c");
deque.addLast("d");
System.out.println(deque);

String str = deque.removeFirst();
System.out.println(str);
System.out.println(deque);

while (deque.size() >0):
{
    System.out.println(deque.removeLast());
}
System.out.println(deque);

// 分析Queue和Priority Queue的源代码

/*
Queue：
    在JAVA中，Queue是一个接口，而并非类。队列通常以FIFO（先进先出）的方式对元素进行排序。
Queue的主要API包含以下：
    1.add(E,e)：将元素e插入队列中，若当前没有空间，则抛出IllegalStateException异常,成功则返回True
    2.element()：检索队列的头部，但并不进行任何修改操作；若队列为空，则抛出NoSuchElementException异常
    3.offer(E,e)：将元素e插入队列中，成功则返回True，失败则返回False
    4.peek()：检索队列的头部，但不进行任何修改操作；若队列为空，则返回NULL
    5.poll()：检索队列的头部，并删除队列头部；若队列为空，则返回NULL
    6.remove()：检索队列的头部，并删除队列头部；若队列为空，则抛出NoSuchElementException异常
*/

/*
Priority Queue：
    在JAVA中，PriorityQueue是一种类。优先队列的元素可以根据其自然顺序进行排序，也可以依据指定的比较器进行排序
    优先队列的头部是指定排序最小的元素，每次移除元素会移除指定排序最小的元素

Priority Queue的构造方法：
    1.PriorityQueue()：构造一个PriorityQueue，初始容量为11，依据自然顺序进行排序
    2.PriorityQueue(int initialCapacity)：构造一个PriorityQueue，初始容量为initialCapacity，依据其自然顺序进行排序
    3.PriorityQueue(int initialCapacity,Comparator<? super E> comparator)，构造一个PriorityQueue，初始容量为initialCapacity，依据比较器对元素进行排序
    4.PriorityQueue(Comparator<? super E> comparator)，构造一个PriorityQueue，初始容量为11，依据比较器对元素进行排序
    5.PriorityQueue​(Collection<? extends E> c)，构造包含指定元素的优先队列
    6.PriorityQueue​(PriorityQueue<? extends E> c)，构造包含指定优先队列中的元素优先队列
    7.PriorityQueue​(SortedSet<? extends E> c)，构造包含指定有序集合中的元素优先队列

Priority Queue的主要API：
    1.add​(E e)：插入指定元素，失败则抛出异常
    2.clear()：删除优先队列中所有元素
    3.comparator()：返回优先队列比较器，若为自然顺序，返回null
    4.contains​(Object o)：若优先队列包含指定元素，返回true
    5.forEach​(Consumer<? super E> action)：对优先队列每个元素执行给定操作，直到处理完毕所有元素或者抛出异常
    6.iterator()：返回优先队列中元素的迭代器
    7.offer​(E e)：将指定元素插入优先队列
    8.remove​(Object o)：将指定元素从队列中删除
    9.toArray()：返回队列中，所有元素的数组
    10. removeAll​(Collection<?> c)：移除优先队列中在指定集合中存在的元素
*/