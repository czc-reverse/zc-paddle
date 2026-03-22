flowchart TD
    User["End Users / LLM / AI Agent"]
    DataSource["Raw Data Sources\nWord/Excel/PowerPoint/PDF/MD/TXT/Databases/API"]

    subgraph Graphiti Processing Layer
        Parser["Document Parsing & Entity Extraction"]
        Builder["Knowledge Graph Construction & Relation Reasoning"]
        Retriever["Hybrid Retrieval: Vector + Graph Traversal"]
    end

    subgraph Neo4j Storage & Query Layer
        GraphStore["Native Graph Storage: Nodes & Relationships"]
        Index["Vector Index / Property Index"]
        CypherEngine["Cypher Query Engine"]
    end

    %% Data Flow Lines
    DataSource --> Parser --> Builder
    Builder --> CypherEngine
    CypherEngine --> GraphStore & Index
    User --> Retriever --> CypherEngine
    CypherEngine --> Retriever --> User
