# GraphQL
GraphQL exercise 

## Base on https://www.unlogged.io/post/getting-started---graphql-with-springboot

💡 GraphQL works between the client and backend services, making data retrieval more efficient. Instead of making multiple requests like you do with REST, you can ask for everything you need in one go with GraphQL. This means you get all your data in a single request, making the process quicker.

GraphQL is a query language for APIs that allows clients to request specific data, often from multiple sources, in a single, flexible query.

## Components of a GraphQL Endpoint

- Schema
- Queries
- Resolvers
- Mutations
- Subscriptions

## Goal
We'll define a User class and a CustomerOrder class, establishing a one-to-many relationship where each user can create multiple orders. User and order details will be stored in separate database tables, ensuring organized data management and enhancing interaction efficiency with clients through our GraphQL API. We'll define schemas, execute queries, and mutations to facilitate seamless data retrieval and manipulation operations within this relational framework.
