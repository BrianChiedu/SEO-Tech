adj_list[tree_to[i]].append(tree_from[i])

    # Helper function to calculate the distance between two nodes using BFS
    def calculate_distance(start, end):
        visited = [False] * tree_nodes
        distance = [0] * tree_nodes
        queue = [start]
        visited[start] = True

        while queue:
            current_node = queue.pop(0)
            for neighbor in adj_list[current_node]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    distance[neighbor] = distance[current_node] + 1
                    queue.append(neighbor)

                    if neighbor == end:
                        return distance[neighbor]

        # If there's no path between start and end, return None
        return None

    # Check if a Pythagorean triple is formed
    def is_pythagorean_triple(a, b, c):
        if a is not None and b is not None and c is not None:
            return a + b == c or a + c == b or b + c == a
        return False

    count = 0
    # Iterate through all possible triples (x, y, z)
    for a in range(tree_nodes):
        for b in range(a + 1, tree_nodes):
            for c in range(b + 1, tree_nodes):
                distance_x = calculate_distance(a, x)
                distance_y = calculate_distance(b, y)
                distance_z = calculate_distance(c, z)

                if is_pythagorean_triple(distance_x, distance_y, distance_z):
                    count += 1

    return count
